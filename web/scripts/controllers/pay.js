'use strict';

rangerApp.controller('payCtrl', ['$scope', '$http', '$window', '$stateParams', '$state', '$timeout',
    function ($scope, $http, $window, $stateParams, $state, $timeout) {

        $scope.payDetails = {
            orderId: -1,
            amount: -1,
            buyerId: -1,
            payPass: undefined
        };

        //订单信息
        var mOrderId = $stateParams.orderId;
        var mUrl = '/Ranger/order/detail/'+mOrderId;
        $http({
            url: mUrl,
            method: 'GET'
        }).then(function (response) {
            $scope.orderdetails = response.data;
            $scope.payDetails.orderId = $scope.orderdetails.orderform.id;
            $scope.payDetails.amount = $scope.orderdetails.price.total;
            $scope.payDetails.buyerId = $window.sessionStorage.angencyIdencyId;
            console.log(response.data);
        }, function (err) {
            console.log(err.data);
        });
        
        //账户余额
        var angencyId = $window.sessionStorage.angencyId;
        var mUrl2 = '/Ranger/angency/detail/'+angencyId;
        $http({
            url: mUrl2,
            method: 'GET'
        }).then(function (response) {
            $scope.angency = response.data;
            console.log(response.data);
        }, function (err) {
            console.log(err.data);
        });
        
        $scope.pay = function () {
            var mUrl3 = '/Ranger/api/trade/pay';
            $http({
                url: mUrl3,
                method: 'POST',
                data: $scope.payDetails
            }).then(function (response) {
                var returnWrapper = response.data;
                console.log(returnWrapper);
                if (returnWrapper.status == 'SUCCEED') {
                    $scope.payresult = {
                        result: true,
                        reason: undefined
                    };
                    $timeout(function () {
                        $state.go('home.detail', {id: $scope.payDetails.orderId});
                    }, 3000);
                    document.getElementById('paysuccess').getElementsByTagName('timer')[0].start();
                } else {
                    switch (response.data.code) {
                        case 'CURRENT_PASSWORD_WRONG':
                            $scope.payresult = {
                                result: false,
                                reason: '密码错误'
                            };
                            break;
                        case 'BALANCE_NOT_ENOUGH':
                            $scope.payresult = {
                                result: false,
                                reason: '余额不足'
                            };
                            break;
                        case 'DUPLICATED_OPERATION':
                            $scope.payresult = {
                                result: false,
                                reason: '已付款'
                            };
                            break;
                        default:
                    }
                }
                $('#payresult').show();
            }, function (err) {
                console.log(err.data);
            });
        };

    }]);

