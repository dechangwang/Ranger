'use strict';

/* App Module */

var rangerApp = angular.module('rangerApp', [
    'ngRoute',
    'RangerControllers'
]);

rangerApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
        when('/home', {
            templateUrl: 'views/home.html'
            // controller: 'registerCtrl'
        }).
        otherwise({
            redirectTo: '/'
        });
    }]);
