'use strict';
/**
 * Created by wangdechang on 2016/4/28.
 */

rangerApp.controller('UserinfoController', ['$scope', '$http', function ($scope, $http) {
    $scope.userInfo = {
        name: '',
        type: '身份证',
        number: '',
        rnumber:'',
        phone: '',
        email: '',
        password: '',
        address: '',
        certificate: '',
        brief: '',
        cname:''
    };
    $scope.registerAngency = function (userInfo) {
       //alert("注册" + userInfo.name);
        //userInfo.
        $http.post('/Ranger/angency/register', userInfo)
            .success(function (data) {
                console.log(data);
                alert("register result：  " + data.res);
            }).error(function (err) {
                alert("注册失败  " + err);
            })
    };

}]);
rangerApp.controller('GuideController', ['$scope', '$http', function ($scope, $http) {
    $scope.guideInfo = {
        name:'',
        gender:'',
        phone:'',
        email:'',
        address:'',
        cname:''
    };
    $scope.registerGuide = function (guideInfo) {
       // alert("导游注册"+guideInfo);
        $http.post('/Ranger/angency/guideregister', guideInfo)
            .success(function (data) {
                console.log(data);
                alert("注册结果  " + data.res);
            }).error(function (err) {
            alert("注册失败  " + err);
        })
    };
}]);
