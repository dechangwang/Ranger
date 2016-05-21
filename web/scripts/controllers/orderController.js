'use strict';



rangerApp.controller("listOrderCtrl",["$scope","$http","$stateParams",function($scope,$http,$stateParams){
    var type=$stateParams.type;
    switch (type){
        case '0':
            $http.get("/order/listAll/7").then(
                function(response){
                    $scope.orderlist=response.data;
                },function(errResponse)
                {
                    alert("error");
                }
            );break;
        case '1':
            $http.get("/order/listToBeAck/7").then(
                function(response){
                    $scope.orderlist=response.data;
                },function(errResponse)
                {
                    alert("error");
                }
            );break;
        case '2':$http.get("/order/listToPay/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '3':$http.get("/order/listHasPaidDeposit/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '4':$http.get("/order/listHasPaidAll/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '5':$http.get("/order/listHasFinished/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '6':$http.get("/order/listHasEvaluated/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '7':$http.get("/order/listHasCanceled/7").then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        default :$http.get("/order/listAll/7").then(
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

    $http.get("/order/detail/"+$stateParams.id).then(
        function(response){
            $scope.orderdetail=response.data;
        },function(err)
        {
            alert("error");
        }
    );
}]);

rangerApp.controller("submitCtrl",["$scope","$http","$stateParams",function($scope,$http,$stateParams){
   /* $scope.tourist={
        'name': '',
        'phone':'',
        'touristTypeId':'',
        'certifateType':'',
        'certifateNumber':'',
        'gender':'',
        'birthDate':'',
        'remark':''
    };*/
    $http.get("/order/detail/"+$stateParams.id).then(
        function(response){
            $scope.orderdetail=response.data;
        },function(err)
        {
            alert("error to get detail");
        }
    );

    $scope.submit=function(tourist)
    {

        $http.post("/order/submittourist/"+$stateParams.id,tourist).success(
            function(response){
                alert(response.result);
            }
        ).error(function(err){
                alert("error to submit");
            });
    };
}]);