app.service('specificationService', function ($http) {
    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../specification/findAll');
    };

    this.findPage = function (page, rows) {
        return $http.get('../specification/findPage/' + page + '/' + rows);
    };

    this.saveSpecification = function (entity) {
        return $http.post('../specification/insertSpecification', entity)
    };

    this.findSingleSpecification = function (id) {
        return $http.post('../specification/findSingleSpecification/' + id)
    };

    this.delete = function (selectIds) {
        return $http.get('../specification/deleteSpecification/' + selectIds);
    }
});