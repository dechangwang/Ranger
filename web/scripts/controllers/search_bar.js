'use strict';

rangerApp.controller('searchBarCtrl', ['$scope', '$http', '$state','$uibModal', 'searchSessionService',
    function($scope, $http, $state,$uibModal, searchSessionService){
    $scope.setoff_bar_locations = [];
    $scope.setoff_bar_location = {
        id: 11,
        name: '上海',
        fatherId: 2,
        e_name:'Shanghai',
        has_child:false
    };
    $scope.search_bar_str = '';
    $scope.get_bar_locations_p = function(father_id){
        console.log(father_id);

    };
    $scope.on_search = function(){
        if($scope.search_bar_str.trim() == ''){
            return;
        }
        var data = {
            'location':$scope.setoff_bar_location,
            'locations':$scope.setoff_bar_locations,
            'search_str':$scope.search_bar_str
        };
        // data.location = $scope.setoff_bar_location;
        // data.locations = $scope.setoff_bar_locations;
        // data.search_str = $scope.search_str;
        searchSessionService.set(data);
        console.log(data);
        $state.go('home.search');
    };
        $scope.select_location = function (size) {
            console.log("select location");
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: 'views/modal/select_location.html',
                size: size,
                controller:'selectLocationCtrl',
                resolve: {
                    initLocation: function () {
                        return $scope.setoff_bar_location;
                    }
                }

            });

            modalInstance.result.then(function (selectedItem) {
                $scope.setoff_bar_location = selectedItem;
            }, function () {
                console.log('Modal dismissed at: ' + new Date());
            });
        };

}]);