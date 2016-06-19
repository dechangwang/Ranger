'use strict';
/**
 * Created by wangdechang on 2016/5/4.
 */
rangerApp.controller('productCtrl', ['$scope', '$http', '$state', '$window', '$uibModal', function ($scope, $http, $state, $window, $uibModal) {
    $scope.products = {
        angency_id: '',
        name: '',
        brief: '',
        detail: '',
        startloc: '',
        targetloc: '',
        duration: '',
        startdate: '',
        adultprice: '',
        childprice: '',
        tag: '',
        setoffway: '',
        backway: '',
        hotelname: '',
        hoteldesc: '',
        hotelname1: '',
        hoteldesc1: '',
        hotelname2: '',
        hoteldesc2: '',
        hotelname3: '',
        hoteldesc3: '',
        postcode: '',
        receiver: '',
        postphone: '',
        postaddress: '',
        destinations: [],
        setoffdate:[],
        guidesname:[],
        train:true,
        airplane:false,
        car:false,
        ship:false,
        other:false,
        otherway:'',
        traffics:[]

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
    } else {
        $scope.products.angency_id = $window.sessionStorage.angencyId;
    }
    $scope.releaseProduct = function (products) {
        console.log(products);
        if($scope.products.airplane == true){
            $scope.products.traffics.push('2');
        }
         if($scope.products.ship == true){
             $scope.products.traffics.push('3');
        }
         if($scope.products.train == true){
             $scope.products.traffics.push('1');
        }
         if($scope.products.car == true){
             $scope.products.traffics.push('4');
        }
         if($scope.products.other == true){
             $scope.products.traffics.push('6');
        }
        console.log($scope.products);
        console.log(products);
        $http.post('/Ranger/products/release', products)
            .success(function (data) {
                console.log(data);
                //alert("发布结果  " + data.res);
                if (data.res == 'success') {
                    $window.sessionStorage.product_id = data.product_id;
                    $state.go('home.product_picture_upload');
                } else {
                    layer.open({
                        title: '信息',
                        content: '发布失败',
                        btn: ['确定', '取消'],
                        yes: function () {
                            layer.closeAll();
                        }
                    });
                }
            }).error(function (err) {
            layer.open({
                title: '信息',
                content: '发布失败',
                btn: ['确定', '取消'],
                yes: function () {
                    layer.closeAll();
                }
            });
        })
    };
    $scope.destinations = [];
    $scope.select_destinations = function (size) {
        var modalInstance = $uibModal.open({
            templateUrl: 'views/modal/select_location.html',
            size: size,
            controller: 'selectLocationCtrl',
            resolve: {
                initLocation: function () {
                    return null;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            // $scope.setoff_bar_location = selectedItem;
            $scope.destinations.push(selectedItem);
            $scope.products.destinations = $scope.destinations;
            console.log($scope.products)
        }, function () {
            console.log('Modal dismissed at: ' + new Date());
        });
        // $scope.destinations.push();
        //console.log($scope.destinations);
    };
    $scope.select_startLocation = function () {
        var modalInstance = $uibModal.open({
            templateUrl: 'views/modal/select_location.html',
            controller: 'selectLocationCtrl',
            resolve: {
                initLocation: function () {
                    return null;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            // $scope.setoff_bar_location = selectedItem;
            //$scope.destinations.push(selectedItem);
            $scope.products.startloc = selectedItem;
            console.log($scope.products)
        }, function () {
            console.log('Modal dismissed at: ' + new Date());
        });
        // $scope.destinations.push();
        //console.log($scope.destinations);
    };
    
    $scope.select_date = function () {
        var modalInstance = $uibModal.open({
            templateUrl: 'views/modal/dateAndGuide.html',
            controller: 'DatepickerPopupDemoCtrl',
            resolve: {
                initLocation: function () {
                    return null;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            $scope.products.setoffdate.push(selectedItem.date);
            $scope.products.guidesname.push(selectedItem.guide);
            console.log(selectedItem)
        }, function () {
            console.log('Modal dismissed at: ' + new Date());
        });
    }

}]);