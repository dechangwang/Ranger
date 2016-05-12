'use strict';
/**
 * Created by wangdechang on 2016/5/12.
 */
//rangerApp.controller('productCtrl', ['$scope', '$http', function ($scope, $http){
rangerApp.controller('invoiceCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.invoiceList = {
        invoice_id: '11111',
        invoice_info: '发票详情',
        apply_time: '2016-6-1',
        price: '1000.0'
    };
    $http({
        url: '/Ranger/invoice/manage',
        method: 'GET'
    }).then(function (response) {
        $scope.invoiceList = response.data;
        console.log(response.data);
    }, function (err) {
        alert("获取失败  " + err);
    });
    $scope.editInvoice = function (invoice) {
        alert("Hello");
    }
}]);