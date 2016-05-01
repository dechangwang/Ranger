'use strict';
/**
 * Created by wangdechang on 2016/4/28.
 */

rangerApp.controller('UserinfoController', ['$scope', '$http', function ($scope, $http) {
    $scope.userInfo = {
        name: '',
        type: '身份证',
        number: '',
        phone: '',
        email: '',
        password: '',
        address: '',
        certificate: '',
        brief: ''
    };
    $scope.registerAngency = function (userInfo) {
       alert("注册" + userInfo.name);
        //userInfo.
        $http.post('/Ranger/angency/register', userInfo)
            .success(function (data) {
                alert("注册成功  " + data);
            }).error(function (err) {
                alert("注册失败  " + err);
            })
    };
}])
