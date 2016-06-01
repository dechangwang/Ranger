'use strict';



rangerApp.controller("listOrderCtrl",["$scope","$http","$stateParams","angency",function($scope,$http,$stateParams,angency){
    var type=$stateParams.type;
    var buyer_id = angency.id;
    if(buyer_id==null) alert("请先登录！");
    switch (type){
        case '0':
            $http.get("/Ranger/order/listAll/"+buyer_id).then(
                function(response){
                    $scope.orderlist=response.data;
                },function(errResponse)
                {
                    alert("error");
                }
            );break;
        case '1':
            $http.get("/Ranger/order/listToBeAck/"+buyer_id).then(
                function(response){
                    $scope.orderlist=response.data;
                },function(errResponse)
                {
                    alert("error");
                }
            );break;
        case '2':$http.get("/Ranger/order/listToPay/"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '3':$http.get("/Ranger/order/listHasPaidDeposit/"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '4':$http.get("/Ranger/order/listHasPaidAll/+"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '5':$http.get("/Ranger/order/listHasFinished/"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '6':$http.get("/Ranger/order/listHasEvaluated/+"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        case '7':$http.get("/Ranger/order/listHasCanceled/"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
        default :$http.get("/Ranger/order/listAll/"+buyer_id).then(
            function(response){
                $scope.orderlist=response.data;
            },function(errResponse)
            {
                alert("error");
            }
        );break;
    }

     $scope.getState=function(statenum){
        //$document.getElementById("state")
        switch (statenum){
            case 1:return '待确认';
            case 11:return '待提交确认单';
            case 12:return '待回执确认单';
            case 2:return '待付款';
            case 3:return '已付订金';
            case 4:return '已付款';
            case 5:return '已完成';
            case 6:return '已评价';
            case 7:return '已取消';
        }
    };
    $scope.isWaitConfirm=function(statenum){
        return statenum==1;
    };


    //$scope.orderlist=orderlist;
}]);

rangerApp.controller("orderDetailCtrl",["$scope","$http","$stateParams",function($scope,$http,$stateParams){

    $http.get("/Ranger/order/detail/"+$stateParams.id).then(
        function(response){
            $scope.orderdetail=response.data;
        },function(err)
        {
            alert("error");
        }
    );

    $scope.getState=function(statenum){
        //$document.getElementById("state")
        switch (statenum){
            case 1:return '待确认';
            case 11:return '待提交确认单';
            case 12:return '待回执确认单';
            case 2:return '待付款';
            case 3:return '已付订金';
            case 4:return '已付款';
            case 5:return '已完成';
            case 6:return '已评价';
            case 7:return '已取消';
        }
    };

}]);

rangerApp.controller("submitCtrl",["$scope","$http","$stateParams","$location",function($scope,$http,$stateParams,$location){

    var orderid=$stateParams.id;
    var  forms=[];

    $http.get("/Ranger/order/detail/"+orderid).then(
        function(response){
            $scope.orderdetail=response.data;
        },function(err)
        {
            alert("error to get detail");
        }
    );

    $scope.submit=function(tourist)
    {


        $http.post("/Ranger/order/submittourist/"+orderid,tourist).success(
            function(response){
                alert(response.result);
               // $scope.submitresult=response.result;
                /*$location.path("/home/orderDetail/"+orderid);
                var curUrl = $location.absUrl();
                alert(curUrl);*/
            }
        ).error(function(err){
                alert("error to submit");
            });
    };

    //forms.push(document.getElementById("touristForm"));

    var addInputElement=function(form,type,innertext,inputname) {
        var label = document.createElement("label");
        label.innerText = innertext;

        var input = document.createElement("input");
        input.type = type;
        input.name = inputname;

        input.required=true;

        form.appendChild(label).appendChild(input);
    };

    var addSelectElement=function(form,selectLabel,values,names,name)
    {
        var label = document.createElement("label");
        label.innerText = selectLabel;

        var select=document.createElement("select");
        select.required=true;

        select.name=name;
        for(var i=0;i<values.length;i++){
            var option=document.createElement("option");
            option.value=values[i];
            option.innerText=names[i];
            select.appendChild(option);
        }
        form.appendChild(label).appendChild(select);

    };
    $scope.createForm=function()
    {
      var submitForm=document.createElement("form");

        document.getElementById("touristForms").appendChild(submitForm);

        addInputElement(submitForm,"text","姓名:","name");
        addInputElement(submitForm,"text","手机:","phone");
        addSelectElement(submitForm,"客户类型:",[1,2],["成人","儿童"],"touristTypeId");
        addSelectElement(submitForm,"证件类型:",["身份证","护照"],["身份证","护照"],"certifateType");
        addInputElement(submitForm,"text","证件号码:","certifateNumber");
        addSelectElement(submitForm,"性别:",[0,1],["男","女"],"gender");
        addInputElement(submitForm,"date","出生日期:","birthDate");
        addInputElement(submitForm,"text","备注:","remark");
        addInputElement(submitForm,"email","邮箱:","email");

      /*  var submit=document.createElement("input");
        submit.type="submit";
        submit.value="提交游客信息";
        submitForm.appendChild(submit);*/

        submitForm.method="post";
        submitForm.action="/Ranger/order/submittourist2/"+orderid;

        forms.push(submitForm);
    };

    $scope.submitAll=function()
    {
      //forms[0].submit($scope.tourist);
        //forms[1].submit();
            var names=document.getElementsByName("name");


            var phones=document.getElementsByName("phone");
        var touristTypeIds=document.getElementsByName("touristTypeId");
        var certifateTypes=document.getElementsByName("certifateType");
        var certifateNumbers=document.getElementsByName("certifateNumber");
        var genders=document.getElementsByName("gender");
        var birthDates=document.getElementsByName("birthDate");
        var remarks=document.getElementsByName("remark");
        var emails=document.getElementsByName("email");
        var tourists=[];
        for(var i=0;i<names.length;i++)
        {
            tourists.push(
                {
                    "name":names[i].value,
                    "phone":phones[i].value,
                "touristTypeId":touristTypeIds[i].value,
                "certifateType":certifateTypes[i].value,
                "certifateNumber":certifateNumbers[i].value,
                    "gender":genders[i].value,
                    "birthDate":birthDates[i].value,
                    "remark":remarks[i].value,
                    "email":emails[i].value
                })
        }
        $http.post("/Ranger/order/submittourist/"+orderid,tourists).then(
            function(response){
                alert(response.data)
            },function(err){
                alert("error");
            }
        );

    };




  /*  if($scope.submitresult=="success")
    {
        alert("提交成功");
        $http.put("/Ranger/order//changeOrderState",orderid).then(
            function(resposne){
                alert("修改状态成功");
            },function(error){
                alert("修改状态失败");
            }
        )
    }
    if($scope.submitresult=="fail")
    {
        alert("提交失败");
    }*/
}]);