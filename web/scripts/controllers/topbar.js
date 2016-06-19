/**
 * Created by Dai on 6/19/16.
 */
'use strict';

rangerApp.controller("topBarCtrl", ["$scope", "$http", "$stateParams", "$window", "$state",'angency', 'Angency',
    function($scope, $http, $stateParams, $window, $state, angency, Angency){
        $scope.logout = function(){
            $window.sessionStorage.angencyId = -1;
            angency.id = -1;
            Angency.setAngencyId(-1);
            console.log("退出登录");
            $state.reload();
        };

        $scope.isLogout = function(){
            if($window.sessionStorage.angencyId && angency.id >= 0){
                return false;
            }else{
                return true;
            }
        };

        $scope.isLogon = function(){
            return !$scope.isLogout();
        }


    }]);