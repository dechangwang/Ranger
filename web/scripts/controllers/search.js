/**
 * Created by daidongyang on 5/15/16.
 */

'use strict';

rangerApp.controller('searchCtrl', ['$scope', '$http', '$uibModal', 'searchSessionService',
    function ($scope, $http, $uibModal, searchSessionService) {
        $scope.results = [];

        $scope.page={
            "pageSize":10,"pageNo":1,"totalCount":9
        };

        $scope.setoff_location = {
            id: 11,
            name: '上海',
            fatherId: 2,
            e_name: 'Shanghai',
            has_child: false
        };

        $scope.destinations = [];

        // $scope.setoff_locations = [];

        $scope.basic_search_str = '';

        // trafic
        $scope.traffic_train = false;
        $scope.traffic_plane = false;
        $scope.traffic_ship = false;
        $scope.traffic_bus = false;
        $scope.traffic_other = false;


        // date
        $scope.setoff_year = false;
        $scope.setoff_year_content = 2016;
        $scope.setoff_month = false;
        $scope.setoff_month_content = 1;
        $scope.setoff_day = false;
        $scope.setoff_day_content = 1;

        $scope.process_traffic_setoff = function(){
            if($scope.traffic_train){
                $scope.search_condition.search_str += " 火车";
            }
            if($scope.traffic_plane){
                $scope.search_condition.search_str += " 飞机";
            }
            if($scope.traffic_ship){
                $scope.search_condition.search_str += " 轮船";
            }
            if($scope.traffic_bus){
                $scope.search_condition.search_str += " 汽车";
            }
            if($scope.traffic_other){
                $scope.search_condition.search_str += " 其他";
            }
            if($scope.setoff_year){
                $scope.search_condition.search_str += " "+$scope.setoff_year_content+"年";
            }
            if($scope.setoff_month){
                $scope.search_condition.search_str += " "+$scope.setoff_month_content+"月";
            }
            if($scope.setoff_day){
                $scope.search_condition.search_str += " "+$scope.setoff_day_content+"日";
            }
        };

        $scope.search_condition = {
            'search_str': '',
            'setoff_location_id': 0,
            'first_result': 0,
            'result_size': 10,
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
            $scope.search_condition.setoff_location_id = $scope.setoff_location.id;
            $scope.search_condition.search_str = $scope.basic_search_str;
            for (var dest_i in $scope.destinations) {
                // console.log(destination);
                if($scope.destinations[dest_i].name){
                    $scope.search_condition.search_str += " " + $scope.destinations[dest_i].name.trim();
                }

            }
            $scope.process_traffic_setoff();
            // log search_condition
            console.log($scope.search_condition);

            $scope.search_condition.search_str = $scope.search_condition.search_str.trim();
            if ($scope.search_condition.search_str == '') {
                return;
            }

            if(!$scope.keep_current_page){
                $scope.page.pageNo = 1;
            }
            $scope.search_condition.first_result = ($scope.page.pageNo - 1) * $scope.search_condition.result_size + 1;
            $scope.keep_current_page = false;

            $http.post('/Ranger/api/searchproduct/list', $scope.search_condition)
                .success(function (data) {
                    $scope.results = data;
                    console.log(data);
                })
                .error(function (err) {
                    alert(err);
                });
            $scope.get_results_count();
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
            if (data) {
                console.log(data);
                $scope.setoff_location = data.location;
                $scope.setoff_locations = data.locations;
                $scope.basic_search_str = data.search_str;
                $scope.search();
                searchSessionService.set(null);
            }

        };

        $scope.select_destinations = function (size) {
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: 'views/modal/select_location.html',
                size: size,
                controller: 'selectLocationCtrl',
                resolve: {
                    initLocation: function () {
                        return null;
                    }
                }

            });

            modalInstance.result.then(function (selectedItem) {
                // $scope.setoff_bar_location = selectedItem;
                $scope.destinations.push(selectedItem);
            }, function () {
                console.log('Modal dismissed at: ' + new Date());
            });
            // $scope.destinations.push();
            console.log($scope.destinations);
        };

        $scope.select_location = function (size) {
            console.log("select location");
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: 'views/modal/select_location.html',
                size: size,
                controller: 'selectLocationCtrl',
                resolve: {
                    initLocation: function () {
                        return $scope.setoff_location;
                    }
                }

            });

            modalInstance.result.then(function (selectedItem) {
                $scope.setoff_location = selectedItem;
            }, function () {
                console.log('Modal dismissed at: ' + new Date());
            });
        };

        $scope.set_result_order = function (i) {
            $scope.search_condition.order = i;
            $scope.search();
        };
        $scope.updatepages = false;

        $scope.enableUpdatePages = function(){
            $scope.updatePages = true;
        };
        $scope.get_results_count=function(){

                var counts = 1;
                $http.post('/Ranger/api/searchproduct/resultsCount', $scope.search_condition)
                    .success(function (data) {
                        // $scope.results = data;
                        $scope.page.totalCount = data;
                        console.log(data);
                    })
                    .error(function (err) {
                        alert(err);
                    });

                console.log($scope.page);
        };
        $scope.keep_current_page = false;
        $scope.to_keep_current_page = function(){
            $scope.keep_current_page = true;
        };

        $scope.pageChanged = function(){
            $scope.keep_current_page = true;
            $scope.search();
        };

        $scope.remove_destination = function(item){
            var index = $scope.destinations.indexOf(item);
            $scope.destinations.splice(index, 1);
        };

        $scope.get_purchase_count = function(product){
            var purchaseCount = 0;
            for(var i = 0; i < product.tripSetoffs.length; i++){
                purchaseCount += product.tripSetoffs[i].purchaseCount;
            }
            return purchaseCount;
        };

        $scope.on_begin();

    }]);
