'use strict';
/**
 * Created by wangdechang on 2016/5/14.
 */
rangerApp.controller('angencyInfoCtrl', ['$scope', '$http', '$window', function ($scope, $http, $window) {
    $scope.angencyInfo = {
        id: '',
        name: '',
        type: '',
        number: '',
        rnumber: '',
        phone: '',
        email: '',
        password: '',
        address: '',
        certificate: '',
        brief: '',
        cname: ''
    };

    $scope.angencyID = {
        id: ''
    };
    if (!$window.sessionStorage.angencyId) {
        layer.open({
            title: '登录信息',
            content: '未登录，请先登录',
            btn: ['确定', '取消'],
            /*  area: ['390px', '330px'],*/
            yes: function () {
                layer.closeAll();
                $state.go('home.login');
            }
        });
        window.history.back();
    } else {
        $scope.angencyID.id = $window.sessionStorage.angencyId;
        $http({
            url: '/Ranger/angency/info',
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest: function (data) {
                return $.param(data);
            },
            data: $scope.angencyID
        }).then(function (response) {
            $scope.angencyInfo = response.data[0];
            console.log(response.data[0]);
        }, function (err) {
            alert("获取失败  " + err);
        });
    }

    $scope.editAngencyInfo = function (angencyInfo) {
        console.log(angencyInfo);
        $http({
            url: '/Ranger/angency/editangency',
            method: 'POST',
            data: angencyInfo
        }).then(function (response) {
            if (response.data.res == 'succeed') {
                alert("修改信息成功");
            } else {
                alert("修改失败");
            }
            console.log(response.data);
        }, function (err) {
            alert("修改失败  " + err);
        });

    }
}]);

rangerApp.controller('guideInfoCtrl', ['$scope', '$http','$uibModal','$window','$state',function ($scope, $http,$uibModal,$window,$state) {
    $scope.guideInfo = {
        id: '',
        name: '',
        gender: '',
        phone: '',
        email: '',
        address: '',
        cname: ''
    };

    $scope.data={
        phone:'',
        angency_id:''
    };
    if (!$window.sessionStorage.angencyId) {
        layer.open({
            title: '登录信息',
            content: '未登录，请先登录',
            btn: ['确定', '取消'],
            /*  area: ['390px', '330px'],*/
            yes: function () {
                layer.closeAll();
                $state.go('home.login');
            }
        });
        //window.history.back();
    }else{
        $scope.data.angency_id = $window.sessionStorage.angencyId;
        var modalInstance = $uibModal.open({
            templateUrl: 'views/modal/input_dialog.html',
            controller: 'inputModalCtrl',
            backdrop: 'static',
            resolve: {
                data: function () {
                    return null;
                }
            }
        });

        modalInstance.result.then(function (data) {
            $scope.data.phone = data.phone;
            $http({
                url: '/Ranger/angency/guideinfo',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                },
                transformRequest: function (data) {
                    return $.param(data);
                },
                data:$scope.data
            }).then(function (response) {
                $scope.guideInfo = response.data;
                if(response.data.res =='error'){
                    layer.open({
                        title: '信息',
                        content: '输入的导游电话有误',
                        btn: ['确定', '取消'],
                        /*  area: ['390px', '330px'],*/
                        yes: function () {
                            layer.closeAll();
                        }
                    });
                }
            }, function (err) {
                alert("获取失败  " + err);
            });
        });
    }


    /*$http({
        url: '/Ranger/angency/guideinfo',
        method: 'GET'
    }).then(function (response) {
        $scope.guideInfo = response.data;
    }, function (err) {
        alert("获取失败  " + err);
    });*/

    $scope.editGuideInfo = function (guideInfo) {
        console.log(guideInfo);
        $http({
            url: '/Ranger/angency/editguide',
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest: function (data) {
                return $.param(data);
            },
            data: guideInfo
        }).then(function (response) {
            if (response.data.res == 'succeed') {
                layer.open({
                    title: '信息',
                    content: '修改信息成功',
                    btn: ['确定', '取消'],
                    /*  area: ['390px', '330px'],*/
                    yes: function () {
                        layer.closeAll();
                    }
                });
            } else if (response.data.res == 'no') {
                alert("所属公司名有误");
            } else {
                alert("修改失败");
            }
            console.log(response.data);
        }, function (err) {
            alert("修改失败  " + err);
        });
    }

}]);

rangerApp.controller('GuideCtrl', ['$scope', '$http', '$window', '$state', '$uibModal', function ($scope, $http, $window, $state, $uibModal) {
    $scope.angencyID = {
        id: ''
    };

    $scope.guideList = {
        id: '',
        name: '',
        gender: '',
        phone: '',
        email: '',
        address: '',
        cname: ''
    };
    if (!$window.sessionStorage.angencyId) {
        layer.open({
            title: '登录信息',
            content: '未登录，请先登录',
            btn: ['确定', '取消'],
            yes: function () {
                layer.closeAll();
                $state.go('home.login');
            }
        });
    } else {
        $scope.angencyID.id = $window.sessionStorage.angencyId;
        $http({
            url: '/Ranger/angency/guideList',
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest: function (data) {
                return $.param(data);
            },
            data: $scope.angencyID
        }).then(function (response) {
            $scope.guideList = response.data;
            console.log(response.data)
        }, function (err) {
            alert("获取失败  " + err);
        });
    }

    $scope.addGuide = function () {
        var modalInstance = $uibModal.open({
            templateUrl: 'views/modal/addGuide.html',
            controller: 'addGuideModalCtrl',
            backdrop: 'static',
            resolve: {
                data: function () {
                    return null;
                }
            }
        });

        modalInstance.result.then(function (employee) {
          
        });
    };

    $scope.editGuide = function (guide) {
        var modalInstance = $uibModal.open({
            templateUrl: 'views/modal/editGuide.html',
            controller: 'guideEditModalCtrl',
            backdrop: 'static',
            resolve: {
                data: function () {
                    return angular.copy(guide);
                }
            }
        });

        modalInstance.result.then(function (guide) {
            console.log(guide);
            $http({
                url: '/Ranger/angency/editGuideByAency',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                },
                transformRequest: function (data) {
                    return $.param(data);
                },
                data: guide
            }).then(function (response) {
                console.log(response.data)
                history.go(0);
            }, function (err) {
                alert("获取失败  " + err);
            });
        });
    };

    $scope.removeGuide = function (guide) {
        var modalInstance =  $uibModal.open({
            templateUrl: 'views/modal/confirm.html',
            controller: 'ConfirmModalCtrl',
            size: 'sm',
            resolve: {
                data: function () {
                    return angular.copy(guide);
                }
            }
        });

        modalInstance.result.then(function (guide) {
            console.log(guide);
            $http({
                url: '/Ranger/angency/deleteGuideByAency',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                },
                transformRequest: function (data) {
                    return $.param(data);
                },
                data: guide
            }).then(function (response) {
                console.log(response.data)
                history.go(0);
            }, function (err) {
                alert("获取失败  " + err);
            });
        });
    };
}]);