//控制层
app.controller('goodsController', function ($scope, $controller, goodsService, itemCatService, typeTemplateService, uploadFileService) {

    $controller('baseController', {$scope: $scope});//继承

    //读取列表数据绑定到表单中  
    $scope.findAll = function () {
        goodsService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };

    //分页
    $scope.findPage = function (page, rows) {
        goodsService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };

    //查询实体
    $scope.findOne = function (id) {
        goodsService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };

    //保存
    $scope.save = function () {
        var serviceObject;  // 服务层对象
        if ($scope.entity.goods.id != null) {   // 如果有ID
            serviceObject = goodsService.update($scope.entity); // 修改
        } else {
            $scope.entity.goodsDesc.introduction = editor.html();
            serviceObject = goodsService.add($scope.entity);    // 增加
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    $scope.entity = {goods: {}, goodsDesc: {}, itemList: []};
                    editor.html('');
                    $scope.itemCat2List = [];
                    $scope.itemCat3List = [];
                    $scope.brandIdsList = [];
                } else {
                    alert(response.message);
                }
            }
        );
    };


    //批量删除
    $scope.dele = function () {
        //获取选中的复选框
        goodsService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                    $scope.selectIds = [];
                }
            }
        );
    };

    $scope.searchEntity = {};//定义搜索对象

    //搜索
    $scope.search = function (page, rows) {
        goodsService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };

    // 一级商品分类
    $scope.itemCat1List = [];
    $scope.findItemCatList = function (parentId) {
        itemCatService.findItemCatByParentId(parentId).success(function (res) {
            $scope.itemCat1List = res;
        })
    };

    // 二级商品分类
    $scope.itemCat2List = [];
    $scope.$watch('entity.goods.category1Id', function (newValue, oldValue) {
        if (undefined != newValue) {
            itemCatService.findItemCatByParentId(newValue).success(function (res) {
                $scope.itemCat2List = res;
                $scope.itemCat3List = [];
                $scope.entity.goods.typeTemplateId = '';
                $scope.brandIdsList = [];
            })
        }
    });

    // 三级商品分类
    $scope.itemCat3List = [];
    $scope.$watch('entity.goods.category2Id', function (newValue, oldValue) {
        if (undefined != newValue) {
            itemCatService.findItemCatByParentId(newValue).success(function (res) {
                $scope.itemCat3List = res;
                $scope.entity.goods.typeTemplateId = '';
                $scope.brandIdsList = [];
            })
        }
    });

    // 模板 id
    $scope.entity = {
        goods: {},
        goodsDesc: {itemImages: [], customAttributeItems: [], specificationItems: []},
        itemList: [{spec: {}, price: 0, num: 99999, status: '0', isDefault: '0'}]
    };
    $scope.$watch('entity.goods.category3Id', function (newValue, oldValue) {
        if (undefined != newValue && '' != newValue) {
            itemCatService.findOne(newValue).success(function (res) {
                $scope.entity.goods.typeTemplateId = res.typeId;
            })
        }
    });

    // 品牌
    $scope.brandIdsList = [];
    $scope.specList = [];
    $scope.$watch('entity.goods.typeTemplateId', function (newValue, oldValue) {
        if (undefined != newValue && '' != newValue) {
            typeTemplateService.findOne(newValue).success(function (res) {
                $scope.brandIdsList = JSON.parse(res.brandIds);
                $scope.entity.goodsDesc.customAttributeItems = JSON.parse(res.customAttributeItems);
            });

            typeTemplateService.findSpecAndOptions(newValue).success(function (res) {
                $scope.specList = res;
            })
        }
    });

    // 图片上传
    $scope.imgage = {color: '', url: ''};
    $scope.uploadFile = function () {
        uploadFileService.uploadFile().success(function (res) {
            if (res.success) {
                $scope.image.url = res.message;
            } else {
                alert(res.message);
            }
        })
    };

    // 保存到图片列表
    $scope.addImage = function () {
        $scope.entity.goodsDesc.itemImages.push($scope.image);
    };

    // 从图片列表删除
    $scope.removeImage = function (index) {
        $scope.entity.goodsDesc.itemImages.splice(index, 1);
    };

    // 将规格和规格选项动态添加到数组中
    $scope.selectSpecAndOptions = function ($event, specName, optionName) {
        // 1. 根据 specName 从 $scope.entity.goodsDesc.specificationItems 中获取对象
        var specObject = $scope.searchObjectByKey($scope.entity.goodsDesc.specificationItems, 'attributeName', specName);
        if (specObject != null) {
            // 2. 获取对象
            if ($event.target.checked) {
                // 2.1 当前选中状态,将规格选项放到规格选项数组(attributeValue)中
                specObject.attributeValue.push(optionName);
            } else {
                // 2.2 当前未选中,将规格选项从规格选项数组中删除
                specObject.attributeValue.splice(specObject.attributeValue.indexOf(optionName), 1);
                // 2.3 判断,规格选项数组是否为空
                if (specObject.attributeValue.length <= 0) {
                    // 2.4 规格选项为空,将规格对象从 $scope.entity.goodsDesc.specificationItems 数组中删除
                    $scope.entity.goodsDesc.specificationItems.splice($scope.entity.goodsDesc.specificationItems.indexOf(specObject), 1);
                }
            }
        } else {
            // 3. 未获取到对象,该规格是第一次添加
            // $scope.entity.goodsDesc.specificationItems.push({'attributeName': specName, 'attributeValue': [optionName]})
            specObject = {'attributeName': '', 'attributeValue': []};
            // 3.1 创建规格对象,保存规格和规格选项
            specObject.attributeName = specName;
            specObject.attributeValue.push(optionName);
            // 3.2 将该对象放到 $scope.entity.goodsDesc.specificationItems 数组中
            $scope.entity.goodsDesc.specificationItems.push(specObject);
        }
    };

    $scope.createItemList = function () {
        // 初始化对象
        $scope.entity.itemList = [{spec: {}, price: 0, num: 99999, status: '0', isDefault: '0'}];
        for (let i = 0; i < $scope.entity.goodsDesc.specificationItems.length; i++) {
            let spec = $scope.entity.goodsDesc.specificationItems[i];
            $scope.entity.itemList = $scope.addColumn($scope.entity.itemList, spec.attributeName, spec.attributeValue);
        }
    };

    $scope.addColumn = function (itemList, specName, options) {
        let newList = [];
        for (let i = 0; i < itemList.length; i++) {
            let item = itemList[i];
            for (let j = 0; j < options.length; j++) {
                let newItemList = JSON.parse(JSON.stringify(item));
                newItemList.spec[specName] = options[j];
                newList.push(newItemList);
            }
        }
        return newList;
    }
});