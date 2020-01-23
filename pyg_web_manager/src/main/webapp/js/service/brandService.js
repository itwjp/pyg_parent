app.service('brandService', function ($http) {
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