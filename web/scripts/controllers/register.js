'use strict';
/**
 * Created by wangdechang on 2016/4/28.
 */

rangerApp.controller('UserinfoController', ['$scope', '$http','$window','$state', function ($scope, $http,$window,$state) {
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
                if(data.res =='permit'){
                    $window.sessionStorage.angencyId = data.id;
                    $state.go('home.angencyregister.upload');
                }else{
                    console.log(data);
                    alert("register result：  " + data.res);
                }

            }).error(function (err) {
                alert("注册失败  " + err);
            })
    };

}]);
rangerApp.controller('GuideController', ['$scope', '$http','$state', function ($scope, $http,$state) {
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
                $state.go('home');
            }).error(function (err) {
            alert("注册失败  " + err);
        })
    };
}]);


rangerApp.controller('loginCtrl', ['$scope', '$http', '$state', 'angency', 'Angency', '$window',
    function($scope, $http, $state, angency, Angency, $window) {
        $scope.account = {
            username: '',
            password: ''
        };
        $scope.login = function (account) {
            $http({
                url: '/Ranger/angency/login',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                },
                transformRequest: function(data) {
                    return $.param(data);
                },
                data: account
            }).then(function (response) {
                if (response.data.result == 'success') {
                    $scope.loginSuccess = true;
                    $window.sessionStorage.angencyId = response.data.angency.id;
                    Angency.setAngencyId(response.data.angency.id);
                    angency.id = response.data.angency.id;
                    window.history.back();
                    // $state.go('home');
                } else {
                    $scope.loginSuccess = false;
                    alert("密码或用户名错误!");
                }
            }, function (err) {
                alter("登录失败  " + err);
            });
        }
    }]);

