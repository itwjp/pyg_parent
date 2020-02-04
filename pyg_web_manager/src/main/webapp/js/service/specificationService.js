app.service('specificationService', function ($http) {
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