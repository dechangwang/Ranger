'use strict';

/* App Module */

var rangerApp = angular.module('rangerApp', ['ui.router', 'ngFileUpload','ngResource']);
rangerApp.value('angency',{id: undefined});
rangerApp.config(['$stateProvider', '$urlRouterProvider', '$locationProvider', function ($stateProvider, $urlRouterProvider, $locationProvider) {

    $urlRouterProvider.otherwise('/home');
    $stateProvider
/*        state('/orderList/:type', {
        templateUrl: 'views/orderList.html',
        controller: 'listOrderCtrl'
    }).
        state('/orderDetail/:id',{
            templateUrl:'views/orderdetail.html',
            controller:'orderDetailCtrl'
        }).
        state('/submitTourist/:orderid',{
            templateUrl:'views/submitTouristInfo.html',
            controller:'submitController'
        })*/
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
                    templateUrl: 'views/homepage.html'
                }
            }
        })
        .state('home.index', {
            url: '/index',
            views: {
                'main@home': {
                    templateUrl: 'views/homepage.html'
                }
            }
        })
        .state('home.angencyregister',{
            url:'/angencyregister',
            views:{
                'main@home':{
                    templateUrl: 'views/angency_register.html'
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
        .state('home.login', {
            url: '/login',
            views: {
                'main@home': {
                    templateUrl: 'views/angency_login.html',
                    controller: 'loginCtrl'
                }
            }
        })
        .state('home.order', {
            url: '/orderList/:type',
            views: {
                'main@home': {
                    templateUrl: 'views/orderList.html'
                }
            }
        })
        .state('home.order.detail',{
            url:'/orderDetail/:id',
            views:{
                'main@home':{
                    templateUrl:'views/orderdetail.html'
                }
            }
        })
        .state('home.notification', {
            url: '/notification',
            views: {
                'main@home': {
                    templateUrl: 'views/notification.html',
                    controller: 'notificationCtrl'
                }
            }
        })
        /*
         .state('notification', {
         url: '/notification',
         views: {
         'main@home': {
         templateUrl: 'views/notification.html',
         controller: 'notificationCtrl'
         }
         }
         });
        * */
        .state('home.account', {
            url: '/account',
            views: {
                'main@home': {
                    templateUrl: 'views/account.html'
                }
            }
        })
        .state('home.product_release', {
            url: '/product_release',
            views: {
                'main@home': {
                    templateUrl: 'views/product_release.html'
                }
            }
        })
        .state('home.my_product', {
            url: '/my_product',
            views: {
                'main@home': {
                    templateUrl: 'views/my_product.html'
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
        .state('home.my_product.edit', {
            url: '/edit/:product_id',
            views: {
                'main@home': {
                    templateUrl: 'views/edit_product.html',
                    controller: 'editProductCtrl'
                }
            }
        })
        .state('home.angency_info', {
            url: '/angency_info',
            views: {
                'main@home': {
                    templateUrl: 'views/angency_info.html'
                }
            }
        })
        .state('home.guide_info', {
            url: '/guide_info',
            views: {
                'main@home': {
                    templateUrl: 'views/guide_info.html'
                }
            }
        })
        .state('home.invoice', {
            url: '/invoice',
            views: {
                'main@home': {
                    templateUrl: 'views/invoice.html'
                }
            }
        })

        .state('home.recharge',{
            url:'/recharge',
            views:{
                'main@home':{
                    templateUrl:'views/recharge.html',
                    controller:'rechargeCtrl'
                }
            }
        })

        .state('search',{
            url:'/search',
            templateUrl:'views/search_product.html'
        })

        .state('product_detail',{
            url:'/product_detail/:p_id',
            views:{
                '':{
                    templateUrl:'views/product_detail.html'
                },
                'topBar@product_detail':{
                    templateUrl:'views/topbar.html'
                },
                'searchBar@product_detail':{
                    templateUrl:'views/search_bar.html'
                },
                'productTemplate@product_detail':{
                    templateUrl:'views/product_detail_template.html'
                }
            }
        });
        


        // .state('search_str',{
        //     url:'/search/:search_str',
        //     templateUrl:'views/search_product.html'
        // })
    // $locationProvider.html5Mode(true);
}]);


