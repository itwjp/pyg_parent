app.controller('brandController', function ($scope, $http, brandService, $controller) {

    // 参数一：要继承的控制器的名称；参数二：配置父控制器的 $scope
    $controller('baseController', {$scope: $scope});

    // 分页
    $scope.findPage = function (page, rows) {
        brandService.findPage(page, rows).success(
            function (response) {
                $scope.brandList = response.rows;
                $scope.paginationConf.totalItems = response.total;  // 更新总记录数
            }
        );
    };

    // 添加品牌
    var brand = {};
    $scope.saveBrand = function () {
        var methodName = "insertBrand";
        if (null != $scope.brand.id) {
            methodName = "updateBrand";
        }

        brandService.saveBrand(methodName, $scope.brand).success(function (res) {
            if (res.success) {
                $scope.reloadList();
            } else {
                alert(res.message);
            }
        })
    };

    // 修改数据回显
    $scope.findSingleBrand = function (id) {
        brandService.findSingleBrand(id).success(function (res) {
            $scope.brand = res;
        })
    };

    $scope.delete = function () {
        brandService.delete($scope.selectIds).success(function (res) {
            alert(res.message);
            if (res.success) {
                $scope.reloadList();
                $scope.selectIds = [];
            }
        })
    }
});