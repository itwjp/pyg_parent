app.controller('baseController', function ($scope, $http) {
    // 重新加载列表 数据
    $scope.reloadList = function () {
        // 切换页码
        $scope.findPage($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    };
    // 分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();    // 重新加载
        }
    };

    $scope.selectIds = [];
    // 更新复选
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {    // 如果被选中，则增加到数组
            $scope.selectIds.push(id);
        } else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index, 1);  // 删除
        }
    };

    // 字符串转 JSON 的工具方法
    $scope.String2Json = function (str, key) {
        let parse = JSON.parse(str);
        let arr = new Array();
        for (let i = 0; i < parse.length; i++) {
            arr.push(parse[i][key]);
        }
        return arr.join();
    }
});