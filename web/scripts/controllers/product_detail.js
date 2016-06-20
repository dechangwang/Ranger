/**
 * Created by daidongyang on 5/16/16.
 */

rangerApp.controller('productDetailCtrl', ['$scope', '$http', '$stateParams','$state','$interval',
    function($scope, $http, $stateParams, $state,$interval){

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

        $scope.setlect_setoff = {};

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

        $scope.tocreate_orderform = function(){
            console.log("go to create orderform");
            $state.go('home.create_orderform',{setoff_id:1});
        };

        $scope.on_begin = function () {
            var product_id = $stateParams.p_id;
            console.log(product_id);
            $scope.get_product(product_id);

        };

        var timeInterval = 2000;
        var currentIndex = 0;
        // setInterval($scope.changeImg,timeInterval);

        console.log($scope.product);
        var stop=$interval(function () {
            if(currentIndex == $scope.product.tripPictures.length -1){
                currentIndex = 0;
            }
            else{
                // console.log(currentIndex);
                currentIndex += 1;
            }
            console.log(currentIndex+"pic:");
            console.log($scope.product.tripPictures[currentIndex].picturePath);
            $scope.trafficImg =$scope.product.tripPictures[currentIndex].picturePath;
        },timeInterval);
        // $scope.changeImg=function (){
        //
        //
        //     if(currentIndex == $scope.product.tripPictures.length -1){
        //         currentIndex = 0;
        //     }
        //     else{
        //         currentIndex += 1;
        //     }
        //     $scope.trafficImg =$scope.product.tripPictures[currentIndex].picturePath;
        // }
            
        $scope.on_begin();
        console.log("lalalaala");
        console.log($scope.product);
    }]);
