'usr strict'
rangerApp.controller('createOrderformCtrl', ['$http', '$scope', '$stateParams', 'angency','$state',
    function($http, $scope, $stateParams, angency, $state){
        var buyer_id = angency.id;
        if(buyer_id){
            $scope.setoff_id = parseInt($stateParams.setoff_id);
            // $scope.create_result = false;
            $scope.booker = "";
            $scope.booker_phone = "";
            $scope.booker_address = "";
            $scope.create_orderform = function(){
                var orderform_data = {
                    "setoff_id":$scope.setoff_id,
                    "booker":$scope.booker,
                    "booker_phone":$scope.booker_phone,
                    "booker_address":$scope.booker_address,
                    "angency_id":angency.id
                };
                console.log(orderform_data);
                $http.post('/Ranger/api/createOrderform/create', orderform_data)
                    .success(function (data) {
                        console.log(data);
                        $state.go('home.order',{type:1});
                        // alert(data);
                    })
                    .error(function (err) {
                        alert(err);
                    });
                
            };
            // $scope.increase_purchase_count = function(){
            //     $http.post('/Ranger/api/createOrderform/increase_purchase_count', $scope.setoff_id)
            //         .success(function (data) {
            //             console.log(data);
            //         })
            //         .error(function(err){
            //             alert(data);
            //         });
            // }
        }else{
            alert("请先登录");
            $state.go('home.login');
            // window.history.back();
        }

}]);