'use strict';
/**
 * Created by wangdechang on 2016/5/4.
 */
rangerApp.controller('productCtrl', ['$scope', '$http','$state','$window', function ($scope, $http,$state,$window){
    $scope.products={
        name:'',
        brief:'',
        detail:'',
        startloc:'上海',
        targetloc:'',
        duration:'',
        startdate:'',
        adultprice:'',
        childprice:'',
        tag:'',
        setoffway:'',
        backway:'',
        hotelname:'',
        hoteldesc:'',
        hotelname1:'',
        hoteldesc1:'',
        hotelname2:'',
        hoteldesc2:'',
        hotelname3:'',
        hoteldesc3:'',
        postcode:'',
        receiver:'',
        postphone:'',
        postaddress:'',
        
    };
    $scope.releaseProduct = function (products) {
        console.log(products);
        $http.post('/Ranger/products/release', products)
            .success(function (data) {
                console.log(data);
                //alert("发布结果  " + data.res);
                if(data.res == 'success'){
                    $window.sessionStorage.product_id = data.product_id;
                    $state.go('home.product_picture_upload');
                }else{
                    layer.open({
                        title: '信息',
                        content: '发布失败',
                        btn: ['确定', '取消'],
                        yes: function(){
                            layer.closeAll();
                        }
                    });
                }
            }).error(function (err) {
            layer.open({
                title: '信息',
                content: '发布失败',
                btn: ['确定', '取消'],
                yes: function(){
                    layer.closeAll();
                }
            });
        })
    }

}]);