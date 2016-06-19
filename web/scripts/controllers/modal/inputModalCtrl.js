'use strict';
/**
 * Created by wangdechang on 2016/6/18.
 */
rangerApp.controller('inputModalCtrl',function ($scope, $uibModalInstance, data) {
    $scope.data = {
        phone:'',
        angency_id:''
    };
    $scope.data = data;
    console.log(data);
    
    $scope.ok = function () {
        $uibModalInstance.close($scope.data);
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
})