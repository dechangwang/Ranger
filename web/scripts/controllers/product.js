'use strict';
/**
 * Created by wangdechang on 2016/5/4.
 */
rangerApp.controller('productCtrl', ['$scope', '$http', function ($scope, $http){
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
                alert("注册结果  " + data.res);
            }).error(function (err) {
            layer.open({
                title: '注册信息',
                content: '注册失败',
                btn: ['确定', '取消'],
                /*  area: ['390px', '330px'],*/
                yes: function(){
                    layer.closeAll();
                }
            });
        })
    }

}]);