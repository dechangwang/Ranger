'use strict';

var orderControllers=angular.module("OrderControllers",[]);

orderControllers.controller("listOrderCtrl",["$scope","$http",function($scope,$http){
    var orders=[];
    orders=$http.get("/Ranger/order/listAll/1").then(
        function(response){
        return response.data;
    },function(errResponse)
        {
            alert("errrrrro");
        }
    )

    $scope.orderlist=orders;
}]);