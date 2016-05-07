'use strict';
/**
 * Created by wangdechang on 2016/5/4.
 */
rangerApp.controller('productCtrl', ['$scope', '$http', function ($scope, $http){
    $scope.products={
        name:''

    };
    $scope.releaseProduct = function (products) {
        Console.log(products);
    }

}]);