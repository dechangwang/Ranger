'use strict';



rangerApp.controller("listOrderCtrl",["$scope","$http","$stateParams",function($scope,$http,$stateParams){
    var type=$stateParams.type;
    switch (type){
        case '0':
            $http.get("/Ranger/order/listAll/7").then(
                function(response){
                    $scope.orderlist=response.data;
                },function(errResponse)
                {
                    alert("error");
                }
            );break;
        case '1':
            $http.get("/Ranger/order/listToBeAck/7").then(
                function(response){
                    $scope.orderlist=response.data;
                },function(errResponse)
                {
                    alert("error");
                }
            );break;
        case '2':$http.get("/Ranger/order/listToPay/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '3':$http.get("/Ranger/order/listHasPaidDeposit/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '4':$http.get("/Ranger/order/listHasPaidAll/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '5':$http.get("/Ranger/order/listHasFinished/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '6':$http.get("/Ranger/order/listHasEvaluated/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '7':$http.get("/Ranger/order/listHasCanceled/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        default :$http.get("/Ranger/order/listAll/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
    }




    //$scope.orderlist=orderlist;
}]);

rangerApp.controller("orderDetailCtrl",["$scope","$http","$stateParams",function($scope,$http,$stateParams){

    $http.get("/Ranger/order/detail/"+$stateParams.id).then(
        function(response){
            $scope.orderdetail=response.data;
        },function(err)
        {
            alert("error");
        }
    );
}]);

rangerApp.controller("submitController",["$scope","$http","$stateParams",function($scope,$http,$stateParams){

    var orderid=$stateParams.orderid;
    $http.get("/Ranger/order/detail/"+orderid).then(
        function(response){
            $scope.orderdetail=response.data;
        },function(err)
        {
            alert("error");
        }
    );

    $scope.submit=function(tourist)
    {
        $http.post("Ranger/order/submittourist/"+orderid,tourist).success(
            function(response){

            }
        ).error(function(err){

            })
    }
}]);