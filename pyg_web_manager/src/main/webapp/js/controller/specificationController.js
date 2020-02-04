app.controller('specificationController', function ($scope, $http, specificationService, $controller) {

    // 参数一：要继承的控制器的名称；参数二：配置父控制器的 $scope
    $controller('baseController', {$scope: $scope});

    // 分页
    $scope.findPage = function (page, rows) {
        specificationService.findPage(page, rows).success(
            function (response) {
                $scope.specificationList = response.rows;
                $scope.paginationConf.totalItems = response.total;  // 更新总记录数
            }
        );
    };

    $scope.entity = {tbSpecification: {}, optionList: []};
    // 添加行函数
    $scope.insertRow = function () {
        $scope.entity.optionList.push({});
    };
    // 删除行函数
    $scope.deleteRow = function (index) {
        $scope.entity.optionList.splice(index, 1);
    };

    // 添加规格
    var specification = {};
    $scope.saveSpecification = function () {
        specificationService.saveSpecification($scope.entity).success(function (res) {
            if (res.success) {
                $scope.reloadList();
            } else {
                alert(res.message);
            }
        })
    };

    // 修改数据回显
    $scope.findSingleSpecification = function (id) {
        specificationService.findSingleSpecification(id).success(function (res) {
            $scope.entity = res;
        })
    };

    $scope.delete = function () {
        specificationService.delete($scope.selectIds).success(function (res) {
            alert(res.message);
            if (res.success) {
                $scope.reloadList();
                $scope.selectIds = [];
            }
        })
    };

});