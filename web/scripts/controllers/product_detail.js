/**
 * Created by daidongyang on 5/16/16.
 */


rangerApp.controller('productDetailCtrl', ['$scope', '$http', '$stateParams','$state','$window','$interval',
    function($scope, $http, $stateParams, $state, $window,$interval){


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


        $scope.selected_setoff = {};

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

            if($scope.selected_setoff.id){
                var myDate = new Date();
                // console.log(myDate.getTime());
                // console.log($scope.selected_setoff.tripSetoffDate);
                if(myDate.getTime() > $scope.selected_setoff.tripSetoffDate){
                    alert("所选项目已过期");
                }else{
                    $state.go('home.create_orderform',{setoff_id:$scope.selected_setoff.id});
                }

            }else{
                alert("请选择出发时间");
            }

        };
        $scope.to_collect = function(){
            console.log("to collect");
            var angency_id = $window.sessionStorage.angencyId;
            if(!angency_id || angency_id<0){
                alert("没有登录,无法收藏!");
                return;
            }
            var param = {
                'product_id':$scope.product.id,
                'angency_id': angency_id
            };
            $http.post('/Ranger/api/getproductdetail/collection',param)
                .success(function(data){
                    console.log(data);
                    if(1 == data || '1' == data){
                        alert("收藏成功");
                    }else{
                        alert("收藏失败,可能已收藏该产品");
                    }
                })
                .error(function(err){
                    console.log(err);
                    alert(err);
                });

        };
        $scope.select_trip_setoff = function(tripSetoff){
            $scope.selected_setoff = tripSetoff;
            console.log($scope.selected_setoff);
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
