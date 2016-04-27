'use strict';

/* App Module */

/*var rangerApp = angular.module('rangerApp', [
    'ngRoute',
    'RangerControllers'
]);*/

var rangerApp = angular.module('rangerApp',['ngRoute']);
rangerApp.config(['$routeProvider',function ($routeProvider) {
    $routeProvider
        .when('/list',{
            templateUrl:'views/route/list.html',
            controller:'RouteListCtl'
        })
        .when('/list/:id',{
            templateUrl:'views/route/detail.html',
            controller:'RouteDetailCtl'
        })
        .when('/angency_register',{
            templateUrl:'views/angency_register.html',
            controller:'angencyController'
        })
        .otherwise({
            redirectTo:'/list'
        });
}]);
