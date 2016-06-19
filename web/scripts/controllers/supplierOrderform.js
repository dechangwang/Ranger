/**
 * Created by Dai on 6/19/16.
 */
'use strict';

rangerApp.controller("supplierOrderCtrl",["$scope","$http","$stateParams","$window",function($scope,$http,$stateParams,$window){
    var type=$stateParams.type;
    var buyer_id = $window.sessionStorage.angencyId;
    if(buyer_id==null)
        alert("请先登录！");
    switch (type){
        case '0':
            $http.get("/Ranger/order/listAll/"+buyer_id).then(
                function(response){
                    $scope.orderlist=response.data;
                },function(errResponse)
                {
                    alert("error");
                }
            );break;
        case '1':
            $http.get("/Ranger/order/listToBeAck/"+buyer_id).then(
                function(response){
                    $scope.orderlist=response.data;
                },function(errResponse)
                {
                    alert("error");
                }
            );break;
        case '2':$http.get("/Ranger/order/listToPay/"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '3':$http.get("/Ranger/order/listHasPaidDeposit/"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '4':$http.get("/Ranger/order/listHasPaidAll/+"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '5':$http.get("/Ranger/order/listHasFinished/"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '6':$http.get("/Ranger/order/listHasEvaluated/+"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '7':$http.get("/Ranger/order/listHasCanceled/"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        default :$http.get("/Ranger/order/listAll/"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
    }

    $scope.getState=function(statenum){
        //$document.getElementById("state")
        switch (statenum){
            case 1:return '待确认';
            case 11:return '待提交确认单';
            case 12:return '待回执确认单';
            case 2:return '待付款';
            case 3:return '已付订金';
            case 4:return '已付款';
            case 5:return '已完成';
            case 6:return '已评价';
            case 7:return '已取消';
        }
    };
    $scope.isWaitConfirm=function(statenum){
        return statenum==1;
    };
    $scope.isFinished=function(state){
        return state==5;
    };


    //$scope.orderlist=orderlist;
}]);

