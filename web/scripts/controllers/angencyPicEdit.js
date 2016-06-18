'use strict';
/**
 * Created by wangdechang on 2016/6/13.
 */
rangerApp.controller('angencyPicCtrl', ['$scope', 'fileUpload','$http','$window','$state',function ($scope,fileUpload,$http,$window,$state) {
    $scope.pictureList={
        url:''
    };

    $scope.info={
        id:''
    };
    $scope.idAndPicName={
        id:'',
        name:''
    };

    if(!$window.sessionStorage.angencyId){
        layer.open({
            title: '登录信息',
            content: '未登录，请先登录',
            btn: ['确定', '取消'],
            /*  area: ['390px', '330px'],*/
            yes: function(){
                layer.closeAll();
                $state.go('home.login');
            }
        });
       // window.history.back();
    }else{
        console.log($window.sessionStorage.angencyId)
        $scope.info.angencyId = $window.sessionStorage.angencyId
        $http({
            url: '/Ranger/picture/edit',
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest : function(data) {
                return $.param(data);
            },
            data: $scope.info
        }).then(function (response) {
            $scope.productList = response.data;
            console.log(response.data);
            console.log($scope.productList);
        }, function (err) {
            alert("获取失败  " + err);
        });
    }

    $scope.deletePic = function(url){
        layer.open({
            title: '信息',
            content: '确认删除该图片',
            btn: ['确定', '取消'],
            /*  area: ['390px', '330px'],*/
            yes: function(){
                layer.closeAll();
                $scope.idAndPicName.id = $window.sessionStorage.angencyId;
                $scope.idAndPicName.name = url;
                $http({
                    url: '/Ranger/picture/delete',
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                    },
                    transformRequest : function(data) {
                        return $.param(data);
                    },
                    data:$scope.idAndPicName
                }).then(function (response) {
                   // console.log(response.data);
                }, function (err) {
                    //alert("获取失败  " + err);
                });
                history.go(0);
            }
        });
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

    };


}]);
