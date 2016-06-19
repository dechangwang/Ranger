/**
 * Created by Dai on 6/19/16.
 */
'use strict';

rangerApp.controller("supplierOrderCtrl", ["$scope", "$http", "$stateParams", "$window", "$state",
    function ($scope, $http, $stateParams, $window, $state) {
        // var type = $stateParams.type;
        $scope.supplier_id = $window.sessionStorage.angencyId;
        if ($scope.supplier_id == null) {
            alert("请先登录！");
            $state.go('home.login');
        }
        $scope.state_to_filter = 0;
        $scope.set_state_to_filter = function(state){
            $scope.state_to_filter = state;
        };
        $scope.orderlist = [];
        $scope.load_orderlist = function(){
            $http.post('/Ranger/api/supplierorderform/list', $scope.supplier_id)
                .success(function (data) {
                    $scope.orderlist = data;
                    console.log(data);
                })
                .error(function (err) {
                    alert(err);
                });
            console.log($scope.orderlist);
        };


        $scope.getState = function (statenum) {
            //$document.getElementById("state")
            switch (statenum) {
                case 1:
                    return '待确认';
                case 11:
                    return '待提交确认单';
                case 12:
                    return '待回执确认单';
                case 2:
                    return '待付款';
                case 3:
                    return '已付订金';
                case 4:
                    return '已付款';
                case 5:
                    return '已完成';
                case 6:
                    return '已评价';
                case 7:
                    return '已取消';
            }
        };
        $scope.isWaitConfirm = function (statenum) {
            return statenum == 1;
        };
        $scope.isFinished = function (state) {
            return state == 5;
        };
        $scope.isConfirmed = function(state){
            if(state == 12){
                return true;
            }else if(state < 11 && state >1){
                return true;
            }else{
                return false;
            }
        };
        $scope.isReConfirmed = function(state){
            // console.log(state);
            if(state <11 && state > 1){
                return true;
            }else{
                return false;
            }
        };
        $scope.isReConfirm = function(state){
            return state == 12;
        };

        $scope.load_orderlist();

        //$scope.orderlist=orderlist;
    }]);

