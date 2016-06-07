'use strict';

rangerApp.controller('payCtrl', ['$scope', '$http', '$window', '$stateParams',
    function ($scope, $http, $window, $stateParams) {

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
                if (returnWrapper.status == 'SUCCEED') {
                    $scope.payresult = {
                        result: '成功',
                        reason: undefined
                    };
                } else {
                    if (response.data.code == 'CURRENT_PASSWORD_WRONG') {
                        $scope.payresult = {
                            result: '失败',
                            reason: '密码错误'
                        }
                    } else {
                        $scope.payresult = {
                            result: '失败',
                            reason: '余额不足'
                        }
                    }
                }
                $('#payresult').show();
                console.log(response.data);
            }, function (err) {
                console.log(err.data);
            });
        };

    }]);

