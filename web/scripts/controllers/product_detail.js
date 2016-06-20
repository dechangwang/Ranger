/**
 * Created by daidongyang on 5/16/16.
 */

rangerApp.controller('productDetailCtrl', ['$scope', '$http', '$stateParams','$state',
    function($scope, $http, $stateParams, $state){

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
            alert("收藏成功");
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
        

        $scope.on_begin();
        console.log($scope.product);
    }]);
