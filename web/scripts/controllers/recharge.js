'use strict';
/**
 * Created by wangdechang on 2016/5/4.
 */
rangerApp.controller('rechargeCtrl', ['$scope', '$http', '$state',function ($scope, $http,$state){
    $scope.bankCard= {
        id:'',
        angency_id:'',
        owner:'',
        num:'',
        card_number:'',
        bank:''
    };

    $scope.rechargeAnge = function (bankCard) {
        console.log(bankCard);
        $http({
            url:'/Ranger/recharge/money',
            method:'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest : function(data) {
                return $.param(data);
            },
            data:bankCard

        }).then(function (response) {
            if(response.data.res=='success'){
                layer.open({
                    title: '充值信息',
                    content: '充值成功',
                    btn: ['确定', '取消'],
                  /*  area: ['390px', '330px'],*/
                    yes: function(){
                        layer.closeAll();
                        $state.go('home');
                    }
                });
            }else if (response.data.res =='no'){
                layer.open({
                    title: '充值信息',
                    content: '卡号错误',
                    btn: ['确定', '取消'],
                    /*  area: ['390px', '330px'],*/
                    yes: function(){
                        layer.closeAll();
                    }
                });
            }else{
                layer.open({
                    title: '充值信息',
                    content: '充值失败',
                    btn: ['确定', '取消'],
                    /*  area: ['390px', '330px'],*/
                    yes: function(){
                        layer.closeAll();
                     
                    }
                });
            }
        },function (err) {
            alert(err);
            console.log(err);
        })
    }
}]);