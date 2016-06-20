/**
 * Created by Dai on 6/19/16.
 */
'use strict';

rangerApp.controller("supplierOrderCtrl", ["$scope", "$http", "$stateParams", "$window", "$state",'$uibModal',
    function ($scope, $http, $stateParams, $window, $state,$uibModal) {
        // var type = $stateParams.type;
        $scope.supplier_id = $window.sessionStorage.angencyId;
        $scope.reconfirm_path = '';

        $scope.state_to_filter = 0;
        $scope.set_state_to_filter = function (state) {
            $scope.state_to_filter = state;
        };
        $scope.orderlist = [];
        $scope.load_orderlist = function () {
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

        $scope.up_reconfirm_order = {};

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
        $scope.isConfirmed = function (state) {
            if (state == 12) {
                return true;
            } else if (state < 11 && state > 1) {
                return true;
            } else {
                return false;
            }
        };
        $scope.isReConfirmed = function (state) {
            // console.log(state);
            if (state < 11 && state > 1) {
                return true;
            } else {
                return false;
            }
        };
        $scope.isReConfirm = function (state) {
            return state == 12;
        };

        $scope.upload_reconfirm = function(order){
            console.log("upload reconfirm");
            $scope.up_reconfirm_order = order;
            var modalInstance = $uibModal.open({
                templateUrl: 'views/modal/uploadFile.html',
                controller: 'uploadModalCtrl',
                backdrop: 'static',
                resolve: {
                    data: function () {
                        return null;
                    }
                }
            });

            modalInstance.result.then(function (data) {
                var file = data;
                //var file = $scope.myFile;
                console.log('file is ');
                console.dir(file);
                var uploadUrl = "/Ranger/files/docUploadOrd";
                var fd = new FormData();
                fd.append('file', file);

                $http.post(uploadUrl, fd, {
                    transformRequest: angular.identity,
                    headers: {'Content-Type': undefined}
                })
                    .success(function (data) {
                        $scope.reconfirm_path = data.path;
                        console.log(data);
                        console.log($scope.reconfirm_path);
                        $scope.update_orderform_state($scope.reconfirm_path);
                    })
                    .error(function (err) {
                        alert('err');
                        return 'err';
                    });
            });
        };

        $scope.update_orderform_state = function (imagePath) {
            console.log($scope.up_reconfirm_order);
            var idAndWrapper = {
                'id': $scope.up_reconfirm_order.id,
                'content':imagePath
            };

            $http.post('/Ranger/api/supplierorderform/uploadreconfirm', idAndWrapper)
                .success(function (data) {
                    console.log(data);
                    if(1==data){
                        $scope.up_reconfirm_order.state = 2;
                    }

                })
                .error(function(err){
                    alert(err);
                });
        };


        if ($scope.supplier_id == null || $scope.supplier_id < 0) {
            alert("请先登录！");
            $state.go('home.login');
        } else {
            $scope.load_orderlist();
        }

        //$scope.orderlist=orderlist;
    }]);

rangerApp.controller('picUploadCtrl', ['$scope', '$http', '$window', '$state', '$uibModal', function ($scope, $http, $window, $state, $uibModal) {

    $scope.Imgpath = {
        path: ''
    };
    $scope.showUploadFile = function () {
        var modalInstance = $uibModal.open({
            templateUrl: 'views/modal/uploadFile.html',
            controller: 'uploadModalCtrl',
            backdrop: 'static',
            resolve: {
                data: function () {
                    return null;
                }
            }
        });

        modalInstance.result.then(function (data) {
            var file = data;
            //var file = $scope.myFile;
            console.log('file is ');
            console.dir(file);
            var uploadUrl = "/Ranger/files/picUploadOrd";
            var fd = new FormData();
            fd.append('file', file);
            $http.post(uploadUrl, fd, {
                    transformRequest: angular.identity,
                    headers: {'Content-Type': undefined}
                })
                .success(function (data) {
                    $scope.Imgpath.path = data.path;
                    console.log(data);
                    console.log( $scope.Imgpath.path);
                })
                .error(function (err) {
                    alert('err')
                    return 'err';
                });
        });
    };

}]);


