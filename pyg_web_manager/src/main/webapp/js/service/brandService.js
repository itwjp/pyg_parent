app.service('brandService', function ($http) {
    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../brand/findAll');
    };

    this.findPage = function (page, rows) {
        return $http.get('../brand/findPage/' + page + '/' + rows);
    };

    this.saveBrand = function (methodName, brand) {
        return $http.post('../brand/' + methodName, brand)
    };

    this.findSingleBrand = function (id) {
        return $http.post('../brand/findSingleBrand/' + id)
    };

    this.delete = function (selectIds) {
        return $http.get('../brand/deleteBrand/' + selectIds);
    }
});