/**
 * Created by daidongyang on 5/16/16.
 */

rangerApp.controller('productDetailCtrl', ['$scope', '$http',
    function($scope, $http){
        $scope.product = null;
        $scope.product_id = 1;
        $scope.get_product = function(product_id){
            console.log(product_id);
            $http.post('/Ranger/api/getproductdetail/id',product_id)
                .success(function(data){
                    $scope.product = data.res;
                    console.log(data);
                })
                .error(function(err){
                    console.log(err);
                    alert(err);
                });
            // $http.post('/Ranger/api/searchproduct/list', $scope.search_condition)
            //     .success(function (data) {
            //         $scope.results = data;
            //         console.log(data);
            //     })
            //     .error(function (err) {
            //         alert(err);
            //     });
        }
    }]);
