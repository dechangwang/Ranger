'use strict';

rangerApp.factory('searchSessionService', function(){
    var savedData = null;
    function set(data) {
        savedData = data;
    }
    function get() {
        return savedData;
    }

    return {
        set: set,
        get: get
    }
    
});