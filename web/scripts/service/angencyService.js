'use strict';

rangerApp.factory('Angency', function () {
    var service = {};
    var _angencyId = undefined;
    service.setAngencyId = function (angencyId) {
        _angencyId = angencyId;
    };
    service.getAngencyId = function () {
        return _angencyId;
    };
    return service;
});