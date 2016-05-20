'use strict';

rangerApp.controller('notificationCtrl', ['$scope', '$http',
    function ($scope, $http) {
        $http({
            url: '/Ranger/api/notification/unread',
            method: 'GET'
        }).then(function (response) {
            $scope.unread = response.data;
        }, function (err) {
            alert("获取失败  " + err);
        });
    }]);

