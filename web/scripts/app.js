'use strict';

/* App Module */

var rangerApp = angular.module('rangerApp', [
    'ngRoute',
    'RangerControllers'
]);

// rangerApp.config(['$routeProvider',
//     function($routeProvider) {
//         $routeProvider.
//         when('/', {
//             templateUrl: '../views/home.html',
//             controller: 'homeCtrl'
//         }).
//         when('/phones/:phoneId', {
//             templateUrl: 'partials/phone-detail.html',
//             controller: 'PhoneDetailCtrl'
//         }).
//         otherwise({
//             redirectTo: '/Ranger/'
//         });
//     }]);
