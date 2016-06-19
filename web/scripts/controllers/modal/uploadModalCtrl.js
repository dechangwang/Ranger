'use strict';
/**
 * Created by wangdechang on 2016/6/18.
 */
rangerApp.controller('uploadModalCtrl',function ($scope, $uibModalInstance, data) {
    $scope.data = {
        phone:'',
        angency_id:''
    };
    $scope.data = data;
    console.log(data);
    
    $scope.ok = function () {
        $uibModalInstance.close($scope.myFile);
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
})