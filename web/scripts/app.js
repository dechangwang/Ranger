'use strict';

/* App Module */

var rangerApp = angular.module('rangerApp', ['ui.router','ngFileUpload']);
rangerApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/home');
    $stateProvider
        .state('home', {
            url: '/home',
            views: {
                '': {
                    templateUrl: 'views/home.html'
                },
                'topbar@home': {
                    templateUrl: 'views/topbar.html'
                },
                'main@home': {
                    templateUrl: 'views/angency_register.html'
                }
            }
        })
        .state('home.index', {
            url: '/index',
            views: {
                'main@home': {
                    template: 'index page'
                }
            }
        })
        .state('home.guideregister', {
            url: '/guideregister',
            views: {
                'main@home': {
                    templateUrl: 'views/guide_register.html'
                }
            }
        })
        .state('home.order', {
            url: '/order',
            views: {
                'main@home': {
                    template: '订单页面'
                }
            }
        })
        .state('home.notification',{
            url: '/notification',
            views: {
                'main@home': {
                    template: '通知页面'
                }
            }
        })
        .state('home.account',{
            url:'/account',
            views: {
                'main@home': {
                    templateUrl: 'views/account.html'
                }
            }
        })
        .state('home.product_release',{
            url:'/product_release',
            views:{
                'main@home':{
                    templateUrl:'views/product_release.html'
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
