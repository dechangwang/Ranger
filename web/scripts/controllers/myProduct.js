'use strict';
/**
 * Created by wangdechang on 2016/5/11.
 */

rangerApp.controller('myProductCtrl',['$scope','$http','$state',function ($scope, $http,$state) {
    $scope.productList={
        product_id:'',
        product_name:'',
        setoff_time:'',
        release_time:'',
        price:'',
        state:'',
    };
    $http({
        url: '/Ranger/products/lists',
        method: 'GET'
    }).then(function (response) {
        $scope.productList = response.data;
        console.log(response.data);
    }, function (err) {
        alert("获取失败  " + err);
    });
    $scope.editProduct = function (product_id) {
        $state.go('home.my_product.edit',{product_id:product_id});
        /*layer.open({
            type: 2,
            title: '编辑',
            content: 'views/product_release.html',
            btn: ['确定', '取消'],
            area: ['390px', '330px'],
            yes: function(){
                $(that).click();
            }
        });*/
        /*layer.open({
            type: 2 //此处以iframe举例
            ,title: '删除'
            ,shade: 0
            ,offset: [ //为了演示，随机坐标
                Math.random()*($(window).height()-300)
                ,Math.random()*($(window).width()-390)
            ]
            ,content: 'settop.html'
            ,btn: ['继续弹出', '全部关闭'] //只是为了演示
            ,yes: function(){
                $(that).click();
            }
            ,btn2: function(){
                layer.closeAll();
            }

            ,zIndex: layer.zIndex //重点1
            ,success: function(layero){
                layer.setTop(layero); //重点2
            }
        });*/
        //console.log(product);
    }
}]);

rangerApp.controller('editProductCtrl',['$scope','$http','$state','$stateParams',function ($scope, $http,$state,$stateParams) {
    var product_id = $stateParams.product_id;
    console.log(product_id);
    $scope.productInfo={
        id:product_id+"",
        supplier_id:'',
        name:'',
        summary:'',
        duration:'',
        postcode:'',
        post_receiver:'',
        post_address:'',
        post_phone:''
    };
    $http({
        url:'/Ranger/products/info',
        method:'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        transformRequest : function(data) {
            return $.param(data);
        },
        data:$scope.productInfo
    }).then(function (response) {
        $scope.productInfo = response.data;
        console.log(response.data);
    },function (err) {
        console.log(err);
    })

    $scope.editProduct = function (productInfo) {
        console.log(productInfo);
        alert(productInfo.id);
    }
}]);
