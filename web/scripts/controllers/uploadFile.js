'use strict';
/**
 * Created by wangdechang on 2016/5/1.
 */

rangerApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

rangerApp.service('fileUpload', ['$http','$window','$state', function ($http,$window,$state) {

    this.uploadFileToUrl = function (file, uploadUrl) {
        if(!$window.sessionStorage.angencyId){
          //  alert("间隔时间太久");
            $state.go('home.angencyregister');
        }
        var fd = new FormData();
        var id = $window.sessionStorage.angencyId;//$window.sessionStorage.angencyIdContinue;

        fd.append('file', file);
       // fd.append('id','8');
        console.log(file.name);
        fd.append('id',id);
        $http.post(uploadUrl, fd,{
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .success(function () {
                layer.open({
                    title: '信息',
                    content: '上传成功，继续添加？',
                    btn: ['继续', '取消'],
                    /*  area: ['390px', '330px'],*/
                    yes: function(){
                       // $state.go('home.angencyregister.upload');
                        history.go(0);
                        layer.closeAll();
                    },btn2:function () {
                        $state.go('home');
                        layer.closeAll();
                    }
                });
            })
            .error(function () {
                alert('err')
                return 'err';
            });
    }
}]);

rangerApp.controller('myCtrl', ['$scope', 'fileUpload',function ($scope,fileUpload) {

    $scope.uploadFile = function () {
        // alert("Hell");
        var file = $scope.myFile;
        console.log('file is ');
        console.dir(file);
        var uploadUrl = "/Ranger/files/fileUpload";
        fileUpload.uploadFileToUrl(file, uploadUrl);
        //console.log(result);
    };


}]);

rangerApp.controller('picCtrl', ['$scope', 'fileUpload','$http','$window','$state', function ($scope,fileUpload,$http,$window,$state) {
    $scope.picture={
        brief:''
    };
    $scope.uploadFile = function (picture) {
        // alert("Hell");
        var file = $scope.myFile;
        console.log('file is ');
        console.dir(file);
        var uploadUrl = "/Ranger/files/picProductUpload";
        console.log(picture);
        var fd = new FormData();
        fd.append('file', file);
        var product_id = $window.sessionStorage.product_id;
        fd.append('product_id',product_id);
        fd.append('brief',picture.brief);
        $http.post(uploadUrl, fd,{
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .success(function () {
                layer.open({
                    title: '信息',
                    content: '上传成功，继续添加？',
                    btn: ['继续', '取消'],
                    /*  area: ['390px', '330px'],*/
                    yes: function(){
                        // $state.go('home.angencyregister.upload');
                        history.go(0);
                        layer.closeAll();
                    },btn2:function () {
                        $state.go('home');
                        layer.closeAll();
                    }
                });
            })
            .error(function () {
                alert('err')
                return 'err';
            });
        //fileUpload.uploadFileToUrl(file, uploadUrl);
        //console.log(result);
    };


}]);

rangerApp.controller('AlertDemoCtrl', function ($scope) {
    $scope.alerts = [
        { type: 'danger', msg: 'Oh snap! Change a few things up and try submitting again.' },
        { type: 'success', msg: 'Well done! You successfully read this important alert message.' }
    ];

    $scope.addAlert = function() {
        $scope.alerts.push({msg: 'Another alert!'});
    };

    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    };
});

rangerApp.controller('mulImageCtrl', ['$scope', function ($scope) {
    $scope.data = {
        file: null
    };

   /* $scope.upload = function (files) {
        console.log(files);
        if (files && files.length) {
            for (var i = 0; i < files.length; i++) {
                Upload.upload({
                    data: {
                        file: files[i]
                    }
                });
            }        // or send them all together for HTML5 browsers:        Upload.upload({..., data: {file: files}, ...})...;
        }
    }*/
    $scope.upload = function () {
     if (!$scope.data.file) {
     return;
     }
     var url = $scope.params.url;  //params是model传的参数，图片上传接口的url
     var data = angular.copy($scope.params.data || {}); // 接口需要的额外参数，比如指定所上传的图片属于哪个用户: { UserId: 78 }
     data.file = $scope.data.file;
     Upload.upload({
     url: url,
     data: data
     }).success(function (data) {
     $scope.hide(data);
     }).error(function () {
     logger.log('error');
     });
     };
}]);