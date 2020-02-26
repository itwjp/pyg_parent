// 服务层
app.service('uploadFileService', function ($http) {
    this.uploadFile = function () {
        var formData = new FormData();
        formData.append('file', file.files[0]);

        return $http({
            method: "post",
            url: "../../file/upload/",
            data: formData,
            headers: {'Content-type': undefined},
            transformRequest: angular.identity
        })
    }
});
