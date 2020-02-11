//控制层
app.controller('itemCatController', function ($scope, $controller, itemCatService) {

    $controller('baseController', {$scope: $scope});//继承

    //读取列表数据绑定到表单中  
    $scope.findAll = function () {
        itemCatService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };

    //分页
    $scope.findPage = function (page, rows) {
        itemCatService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };

    //查询实体
    $scope.findOne = function (id) {
        itemCatService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };

    // 保存
    $scope.save = function () {
        var serviceObject;//服务层对象
        if ($scope.entity.id != null) {//如果有ID
            serviceObject = itemCatService.update($scope.entity); //修改
        } else {
            $scope.entity.parentId = $scope.parentId;
            serviceObject = itemCatService.add($scope.entity);//增加
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    itemCatService.findItemCatByParentId($scope.parentId).success(function (res) {
                            $scope.itemCatList = res;
                        }
                    );
                } else {
                    alert(response.message);
                }
            }
        );
    };


    // 批量删除
    $scope.dele = function () {
        //获取选中的复选框
        itemCatService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                    $scope.selectIds = [];
                }
            }
        );
    };

    $scope.searchEntity = {};//定义搜索对象

    // 搜索
    $scope.search = function (page, rows) {
        itemCatService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };

    // 查询分类
    $scope.itemCatList = [];
    $scope.findItemCatByParentId = function (parentId) {
        itemCatService.findItemCatByParentId(parentId).success(function (res) {
                $scope.itemCatList = res;
            }
        );
    };

    // 面包屑导航
    $scope.itemCat_01 = {};
    $scope.itemCat_02 = {};
    // 设置一个默认的上级分类
    $scope.parentShowName = "顶级分类";
    // 设置一个默认的上级分类 parent_id
    $scope.parentId = 0;
    // 查询下级分类
    $scope.selectNext = function (itemCat) {
        if (1 == $scope.grade) {
            $scope.itemCat_01 = {};
            $scope.itemCat_02 = {};
            $scope.parentShowName = "顶级分类";
            $scope.parentId = 0;
        } else if (2 == $scope.grade) {
            $scope.itemCat_01 = itemCat;
            $scope.itemCat_02 = {};
            $scope.parentShowName = itemCat.name;
            $scope.parentId = itemCat.id;
        } else if (3 == $scope.grade) {
            $scope.itemCat_02 = itemCat;
            $scope.parentShowName = $scope.itemCat_01.name + " >> " + itemCat.name;
            $scope.parentId = itemCat.id;
        }
        itemCatService.findItemCatByParentId(itemCat.id).success(function (res) {
                $scope.itemCatList = res;
            }
        );
    };

    // 定义一个全局的分类级别,默认为一级
    $scope.grade = 1;
    $scope.setGrade = function (grade) {
        $scope.grade = grade;
    };
});
