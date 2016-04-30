'use strict';


var rangeApp = angular.module('rangerApp', []);

rangeApp.controller('testCtrl', ['$scope', '$http', function($scope, $http) {
    //$http.get('http://localhost:8080/Ranger/api/person').success(function(data) {
    $http.get('/Ranger/api/person').success(function(data) {
        $scope.person = data;
        /*$scope.person = {
            "name": "lsh",
            "age": 99
        };*/
        $scope.d = "This is another d.";
    });
    // $http.get('scripts/controllers/a.json').success(function(data) {
    //     // $scope.person = data;
    //     $scope.person = data;
    // });
    //scripts/controllers/a.json
    /*$scope.person = {
        "name": "lsh",
        "age": 99
    };*/
}]);





// var testController = angular.module('testController', []);
//
// testController.controller('test1Ctrl', ['$scope',
//     function($scope) {
//         $scope.property = 'Test_Property_1';
//     }]);
//
// testController.controller('test2Ctrl', ['$scope',
//     function($scope) {
//         $scope.property = 'Test_Property_2';
//     }]);
