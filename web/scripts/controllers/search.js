/**
 * Created by daidongyang on 5/15/16.
 */

'use strict';

rangerApp.controller('searchCtrl', ['$scope', '$http', 'searchSessionService',
    function ($scope, $http, searchSessionService) {
        $scope.results = [];

        $scope.setoff_location = {
            id: 11,
            name: '上海',
            fatherId: 2,
            e_name:'Shanghai',
            has_child:false
        };

        $scope.setoff_locations = [];

        $scope.search_condition = {
            'search_str': '',
            'setoff_location_id': 0,
            'first_result': 0,
            'result_size': 20,
            'order': 0,
            'min_price': -1,
            'max_price': -1,
            'min_duration': -1,
            'max_duration': -1,
            'limits': []
        };

        $scope.get_comments = function (simplep) {
            var comments = 0;
            var index;
            var trip_setoffs = simplep.tripSetoffs;
            for (index = 0; index < trip_setoffs.length; ++index) {
                comments += trip_setoffs[index].commentCount;
            }
            return comments;
        };

        $scope.search_p = function (search_condition) {
            console.log(search_condition);
            $http.post('/Ranger/api/searchproduct/list', search_condition)
                .success(function (data) {
                    $scope.results = data;
                    console.log(data);
                })
                .error(function (err) {
                    alert(err);
                });
        };

        $scope.search = function () {
            console.log("search");
            if ($scope.search_condition.search_str.trim() == '') {
                return;
            }

            $scope.search_condition.setoff_location_id = $scope.setoff_location.id;

            $http.post('/Ranger/api/searchproduct/list', $scope.search_condition)
                .success(function (data) {
                    $scope.results = data;
                    console.log(data);
                })
                .error(function (err) {
                    alert(err);
                });
        };

        $scope.test_p = function (search_condition) {
            console.log(search_condition);
            $http.post('/Ranger/api/searchproduct/test', $scope.search_condition)
                .success(function (data) {
                    console.log(data);
                    alert(data);
                })
                .error(function (err) {
                    alert(err);
                });
        };

        $scope.test = function () {
            console.log($scope.search_condition);
            $http.post('/Ranger/api/searchproduct/test', $scope.search_condition)
                .success(function (data) {
                    console.log(data);
                    alert(data);
                })
                .error(function (err) {
                    alert(err);
                });
        };

        $scope.get_locations_p = function (father_id) {
            console.log(father_id);

        };

        $scope.on_begin = function () {
            var data = searchSessionService.get();
            if(data){
                console.log(data);
                $scope.setoff_location = data.location;
                $scope.setoff_locations = data.locations;
                $scope.search_condition.search_str = data.search_str;
                $scope.search();
                searchSessionService.set(null);
            }

        }

        $scope.on_begin();
    }]);
