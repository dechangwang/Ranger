'use strict';

/* App Module */

var rangerApp = angular.module('rangerApp', [
    'ngRoute',
    'RangerControllers',
    'OrderControllers'
]);



rangerApp.config(['$routeProvider',
     function($routeProvider) {
         $routeProvider.
         when('/orderList/:type', {
             templateUrl: 'views/orderList.html',
             controller: 'listOrderCtrl'
         }).
             when('/orderDetail/:id',{
                 templateUrl:'views/orderdetail.html',
                 controller:'orderDetailCtrl'
             }).
             when('/submitTourist/:orderid',{
                 templateUrl:'views/submitTouristInfo.html',
                 controller:'submitController'
             }).
         otherwise({
             redirectTo: '/Ranger/'
         });
     }]);
