'use strict';

/* App Module */

var rangerApp = angular.module('rangerApp', ['ui.router']);
rangerApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/angency_register');
    $stateProvider
        .state('angency_register', {
            url: '/angency_register',
            views: {
                '': {
                    templateUrl: 'views/angency_register.html'
                }
            }
        })
});

/*var rangerApp = angular.module('rangerApp',['ngRoute']);
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
 }]);*/
