'use strict';

rangerApp.factory('AngencyRes', function ($resource) {
    return $resource('/Ranger/angency/account', {}, {
        query: {
            method: 'GET'
        }
    });
});