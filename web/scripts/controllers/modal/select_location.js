/**
 * Created by Dai on 6/16/16.
 */

'use strict';

rangerApp.controller('selectLocationCtrl', ['$scope', '$http', '$uibModalInstance', 'initLocation',
    function ($scope, $http, $uibModalInstance, initLocation) {
        // $scope.fatherId = 0;
        $scope.locations = [];
        if (initLocation) {
            $scope.select_location = initLocation;
        } else {
            $scope.select_location = {
                id: 0,
                name: "ROOT",
                fatherId: 0,
                e_name: "ROOT",
                hasChild: true
            };
        }


        $scope.show_location = function (fatherId) {

            $http.post('/Ranger/api/searchproduct/setoffChild', fatherId)
                .success(function (data) {
                    $scope.locations = data;
                    console.log(data);
                })
                .error(function (err) {
                    alert(err);
                });
        };
        //has not been used
        $scope.show_location_cofather = function (id) {
            $http.post('/Ranger/api/searchproduct/setoffCofather', id)
                .success(function (data) {
                    $scope.locations = data;
                    console.log(data);
                })
                .error(function (err) {
                    alert(err);
                });
        };
        $scope.get_location_byId = function (id) {
            $http.post('/Ranger/api/searchproduct/setoffByID', id)
                .success(function (data) {
                    $scope.select_location = data;
                    console.log(data);
                })
                .error(function (err) {
                    alert(err);
                });
        };
        $scope.select = function (location) {
            $scope.select_location = location;
            if (location.hasChild) {
                $scope.show_location(location.id);
            } else {
                $scope.ok();
            }
        };
        $scope.ok = function () {

            $uibModalInstance.close($scope.select_location);
        };
        $scope.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.back = function () {
            var fartherId = $scope.select_location.fatherId;
            if (fartherId < 0) {
                fartherId = 0;
            }
            $scope.select_location = $scope.get_location_byId(fartherId);
            $scope.show_location(fartherId);
        };
        $scope.show_location(0);

    }]);
