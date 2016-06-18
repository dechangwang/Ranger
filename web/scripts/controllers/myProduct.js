'use strict';
/**
 * Created by wangdechang on 2016/5/11.
 */

rangerApp.controller('myProductCtrl',['$scope','$http','$state','angency','$window',function ($scope, $http,$state,angency,$window) {
    $scope.productList={
        product_id:'',
        product_name:'',
        setoff_time:'',
        release_time:'',
        price:'',
        state:'',
    };
    $scope.angencyID = {
        id:''
    };
    console.log( $window.sessionStorage.angencyId);
    if(!$window.sessionStorage.angencyId){
        layer.open({
            title: '登录信息',
            content: '未登录，请先登录',
            btn: ['确定', '取消'],
            /*  area: ['390px', '330px'],*/
            yes: function(){
                layer.closeAll();
                $state.go('home.login');
            }
        });
        window.history.back();
    }else{
        $scope.angencyID.id = $window.sessionStorage.angencyId;
        console.log(angency);
        $http({
            url: '/Ranger/products/lists',
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest : function(data) {
                return $.param(data);
            },
            data: $scope.angencyID
        }).then(function (response) {
            $scope.productList = response.data;
            console.log(response.data);
        }, function (err) {
            alert("获取失败  " + err);
        });
    }

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
        setoff_date:'',
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
        // alert(productInfo.id);
        $http({
            url:'/Ranger/products/edit',
            method:'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest : function(data) {
                return $.param(data);
            },
            data:$scope.productInfo

        }).then(function (response) {
            if(response.data.res=='success'){
                layer.open({
                    title: '修改产品信息',
                    content: '修改成功',
                    btn: ['确定', '取消'],
                    /*  area: ['390px', '330px'],*/
                    yes: function(){
                        layer.closeAll();
                    }
                });
            }else{
                layer.open({
                    title: '修改产品信息',
                    content: '修改失败',
                    btn: ['确定', '取消'],
                    /*  area: ['390px', '330px'],*/
                    yes: function(){
                        layer.closeAll();
                    }
                });
            }
            console.log(response.data);
        },function (err) {
            alert(err);
            console.log(err);
        })
    }
}]);
