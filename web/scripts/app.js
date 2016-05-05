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
         when('/orderList', {
             templateUrl: 'views/orderList.html',
             controller: 'listOrderCtrl'
         }).
         otherwise({
             redirectTo: '/Ranger/'
         });
     }]);
