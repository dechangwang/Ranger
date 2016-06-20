'use strict';

rangerApp.controller('collectionManageCtrl', ['$http', '$scope','$window','$state',
    function ($http, $scope,$window,$state){

        $scope.collections = [];
        $scope.select_collect = {};
        $scope.page={
            "pageSize":10,"currentPage":1,"totalCount":9
        };

        $scope.load_collections = function(angencyId){
            console.log("load collections");
            $http.post('/Ranger/api/collect/list', angencyId)
                .success(function (data) {
                    $scope.collections = data;
                    console.log(data);
                    $scope.page.totalCount = $scope.collections.length;
                })
                .error(function (err) {
                    alert(err);
                });
        };

        $scope.collection_delete = function (product_collection) {
            var collection_id = product_collection.id;
            $scope.select_collect = product_collection;
            $http.post('/Ranger/api/collect/delete', collection_id)
                .success(function(data){
                    console.log(data);
                    alert("删除成功");
                    $scope.collection_delete_front($scope.select_collect);
                    $scope.select_collect = {};
                    $scope.page.totalCount = $scope.collections.length;
                })
                .err(function(err){
                    alert(err);
                });

        };

        $scope.collection_delete_front = function (product_collection) {
            var index = $scope.collections.indexOf(product_collection);
            $scope.collections.splice(index, 1);
        };

        if(!$window.sessionStorage.angencyId || $window.sessionStorage.angencyId < 0){
            alert("请先登录");
            $state.go('home.login');
        }else{
            $scope.load_collections($window.sessionStorage.angencyId);
        }
    }
]);