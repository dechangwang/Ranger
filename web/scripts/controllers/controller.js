'use strict';

/* Controllers */


/*
var rangerControllers = angular.module('RangerControllers', []);
*/
rangerApp.controller('RouteListCtl',function($scope) {
});
rangerApp.controller('RouteDetailCtl',function($scope, $routeParams) {
    $scope.id = $routeParams.id;
});
rangerApp.controller('angencyRegister',function($scope){

});
/*rangerControllers.controller('registerCtrl', ['$scope', '$http',

    function($scope, $http) {
        $scope.account = {
            name: '',
            password: ''
        };
        $scope.register = function (account) {
            alert("进行注册");
            $http.post('/Ranger/api/account/register', account).success(function (data) {

 alert("注册成功  " + data);

            }).error(function (err) {
                alert("注册失败  " + err);
            })
        }
    }]);

rangerControllers.controller('loginCtrl', ['$scope', '$http',
    function($scope, $http) {
        $scope.account2 = {
            name: '',
            password: ''
        };
        $scope.login = function (account2) {
            alert("进行登录");

            $http({
                url: '/Ranger/api/account/login',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                },
                transformRequest : function(data) {
                    return $.param(data);
                },
                data: account2
            }).success(function (response) {
                alert("登录成功  " + response.result);
            }).error(function (err) {
                alert("登录失败  " + err);
            })
        }

    }]);*/


/*
rangerControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Phone',
    function($scope, $routeParams, Phone) {
        $scope.phone = Phone.get({phoneId: $routeParams.phoneId}, function(phone) {
            $scope.mainImageUrl = phone.images[0];
        });

        $scope.setImage = function(imageUrl) {
            $scope.mainImageUrl = imageUrl;
        };
    }]);*/

/*
var rangeApp = angular.module('rangerApp', []);

rangeApp.controller('testCtrl', ['$scope', '$http', function($scope, $http) {
    $http.get('/Ranger/api/person').success(function(data) {
        $scope.person = data;
        /!*$scope.person = {
            "name": "lsh",
            "age": 99
        };*!/
        $scope.d = "This is another d.";
    });
    // $http.get('scripts/controllers/a.json').success(function(data) {
    //     // $scope.person = data;
    //     $scope.person = data;
    // });
    //scripts/controllers/a.json
    /!*$scope.person = {
        "name": "lsh",
        "age": 99
    };*!/
}]);*/
