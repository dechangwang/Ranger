/**
 * Created by wangdechang on 2016/6/18.
 */
'use strict';

rangerApp.controller('ConfirmModalCtrl', function ($scope, $uibModalInstance, data) {
        $scope.data = data;
        $scope.ok = function () {
            $uibModalInstance.close($scope.data);
        };

        $scope.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    });