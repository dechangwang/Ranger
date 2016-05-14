'use strict';
/**
 * Created by wangdechang on 2016/5/14.
 */
rangerApp.controller('angencyInfoCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.angencyInfo = {
        id:'',
        name: '',
        type: '',
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
    $http({
        url: '/Ranger/angency/info',
        method: 'GET'
    }).then(function (response) {
        $scope.angencyInfo = response.data[0];
        console.log(response.data[0]);
    }, function (err) {
        alert("获取失败  " + err);
    });
    $scope.editAngencyInfo = function (angencyInfo) {
        console.log(angencyInfo);
        $http({
            url: '/Ranger/angency/editangency',
            method: 'POST',
            data: angencyInfo
        }).then(function (response) {
            if(response.data.res =='succeed'){
                alert("修改信息成功");
            }else{
                alert("修改失败");
            }
            console.log(response.data);
        }, function (err) {
            alert("修改失败  " + err);
        });
        
    }
}]);

rangerApp.controller('guideInfoCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.guideInfo = {
        id:'',
        name:'',
        gender:'',
        phone:'',
        email:'',
        address:'',
        cname:''
    };
    $http({
        url: '/Ranger/angency/guideinfo',
        method: 'GET'
    }).then(function (response) {
        $scope.guideInfo = response.data;
        console.log(response.data);
    }, function (err) {
        alert("获取失败  " + err);
    });
    
    $scope.editGuideInfo = function (guideInfo) {
        console.log(guideInfo);
        $http({
            url: '/Ranger/angency/editguide',
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest : function(data) {
                return $.param(data);
            },
            data: guideInfo
        }).then(function (response) {
            if(response.data.res =='succeed'){
                alert("修改信息成功");
            }else if(response.data.res =='no'){
                alert("所属公司名有误");
            }else{
                alert("修改失败");
            }
            console.log(response.data);
        }, function (err) {
            alert("修改失败  " + err);
        });
    }

}]);
