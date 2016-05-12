'use strict';

/* App Module */

var rangerApp = angular.module('rangerApp', ['ui.router','ngFileUpload']);
rangerApp.config(['$stateProvider', '$urlRouterProvider','$locationProvider',function ($stateProvider, $urlRouterProvider,$locationProvider) {

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
        .state('home.my_product',{
            url:'/my_product',
            views:{
                'main@home':{
                    templateUrl:'views/my_product.html',
                   /* controller:function ($scope,$http) {
                        $scope.productList={
                            name:'',
                            date:''
                        };
                        $http({
                            url: '/Ranger/products/lists',
                            method: 'GET'
                        }).then(function (response) {
                            $scope.productList = response.data;
                            console.log(response.data);
                        }, function (err) {
                            alert("获取失败  " + err);
                        });
                    }*/
                }
            }
        })
        .state('home.invoice',{
            url:'/invoice',
            views:{
                'main@home':{
                    templateUrl:'views/invoice.html'
                }
            }
        })
    // $locationProvider.html5Mode(true);
}]);

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


