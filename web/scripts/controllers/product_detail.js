/**
 * Created by daidongyang on 5/16/16.
 */

rangerApp.controller('productDetailCtrl', ['$scope', '$http', '$stateParams',
    function($scope, $http, $stateParams){
        $scope.product = {
            'id':0,
            'name':'',
            'setoffLocation':{},
            'summary':'',
            'supplier':{},
            'clickRate':0,
            'searchContent':'',
            'postPhone':'',
            'postAddress':'',
            'postReceiver':'',
            'postcode':'',
            'tripAccomodations':[],
            'tripDestination':[],
            'tripDetails':[],
            'tripPictures':[],
            'tripPrices':[],
            'tripSetoffs':[],
            'tripTraffics':[]
        };

        $scope.get_product = function(product_id){
            console.log(product_id);
            $http.post('/Ranger/api/getproductdetail/id',product_id)
                .success(function(data){
                    console.log(data);
                    $scope.product = data
                    console.log($scope.product);
                })
                .error(function(err){
                    console.log(err);
                    alert(err);
                });
        };

        $scope.on_begin = function () {
            var product_id = $stateParams.p_id;
            console.log(product_id);
            $scope.get_product(product_id);

        };
            
        $scope.on_begin();
        console.log($scope.product);
    }]);
