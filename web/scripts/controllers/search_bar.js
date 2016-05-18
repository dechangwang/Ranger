'use strict';

rangerApp.controller('searchBarCtrl', ['$scope', '$http', '$state', 'searchSessionService',
    function($scope, $http, $state, searchSessionService){
    $scope.setoff_bar_locations = [];
    $scope.setoff_bar_location = {
        id : 11,
        name : '上海',
        fatherId : 2
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
        $state.go('search');
    }

}]);