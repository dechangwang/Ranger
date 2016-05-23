'use strict';

rangerApp.controller('notificationCtrl', ['$scope', '$http', 'Angency', '$window',
    function ($scope, $http, Angency, $window) {
        // var angencyId = Angency.getAngencyId();
        var angencyId = $window.sessionStorage.angencyId;
        var mUrl = '/Ranger/api/notification/unread/' + angencyId;
        $http({
            url: mUrl,
            method: 'GET'
        }).then(function (response) {
            $scope.notis = response.data;
        }, function (err) {
            alert("获取失败  " + err);
        });
        $scope.unread = function () {
            // var angencyId = Angency.getAngencyId();
            var angencyId = $window.sessionStorage.angencyId;
            var mUrl1 = '/Ranger/api/notification/unread/' + angencyId;
            $http({
                url: mUrl1,
                method: 'GET'
            }).then(function (response) {
                $scope.notis = response.data;
            }, function (err) {
                alert("获取失败  " + err.data);
            });
        };
        $scope.read = function () {
            // var angencyId = Angency.getAngencyId();
            var angencyId = $window.sessionStorage.angencyId;
            var mUrl2 = '/Ranger/api/notification/read/' + angencyId;
            $http({
                url: mUrl2,
                method: 'GET'
            }).then(function (response) {
                $scope.notis = response.data;
            }, function (err) {
                alert("获取失败  " + err.data);
            });
        };
        $scope.all = function () {
            // var angencyId = Angency.getAngencyId();
            var angencyId = $window.sessionStorage.angencyId;
            var mUrl3 = '/Ranger/api/notification/all/' + angencyId;
            $http({
                url: mUrl3,
                method: 'GET'
            }).then(function (response) {
                $scope.notis = response.data;
            }, function (err) {
                alert("获取失败  " + err.data);
            });
        };
        $scope.setViewed = function (nid) {
            var mUrl4 = '/Ranger/api/notification/setviewed/' + nid;
            $http({
                url: mUrl4,
                method: 'GET'
            }).then(function (response) {
                var re = response.data;
                //alert(re);
                /*if (re === 'true') {
                    alert(true);
                } else {
                    alert(false);
                }*/
            }, function (err) {
                alert(err.data);
            });
        }
    }]);

