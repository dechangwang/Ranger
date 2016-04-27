<%--
  Created by IntelliJ IDEA.
  User: wangdechang
  Date: 2016/4/24
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="UserInfoModule">
<head>
    <title>旅游社注册 </title>

    <script type="text/javascript" src="../../bower_components/angular/angular.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="../../js/form.js"></script>
</head>
<body>
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="panel-title">旅行社注册</div>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-12">
                <form action="/angency/register" method="post" class="form-horizontal" role="form"
                      ng-controller="UserinfoController" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-md-2 control-label">注册人名字：
                        </label>

                        <div class="col-md-10">
                            <input type="text" name="name" class="form-control" ng-model="userInfo.name"
                                   placeholder="请输入注册人名字" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">注册人证件类型：
                        </label>

                        <div class="col-md-10">
                            <input type="text" name="type" class="form-control" ng-model="userInfo.type"
                                   placeholder="请输入注册人证件类型" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">注册证件号码：
                        </label>

                        <div class="col-md-10">
                            <input type="text" name="number" class="form-control" ng-model="userInfo.number"
                                   placeholder="请输入注册人证件号码" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">电话：
                        </label>

                        <div class="col-md-10">
                            <input type="number" name="phone" class="form-control" ng-model="userInfo.phone"
                                   placeholder="请输入注册人电话" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">邮箱：
                        </label>

                        <div class="col-md-10">
                            <input type="email" name="email" class="form-control" ng-model="userInfo.email"
                                   placeholder="请输入正确的邮箱" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">密码：
                        </label>

                        <div class="col-md-10">
                            <input type="password" name="password" class="form-control" ng-model="userInfo.password"
                                   placeholder="请输入安全的密码" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">地址：
                        </label>

                        <div class="col-md-10">
                            <input type="text" name="address" class="form-control" ng-model="userInfo.address"
                                   placeholder="请输入地址" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">上传证书
                        </label>

                        <div class="col-md-10">
                            <input type="file" name="certificate" class="form-control" ng-model="userInfo.file"
                                   placeholder="" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label">简介：
                        </label>

                        <div class="col-md-10">
                            <textarea type="area" name="brief" rows="5" class="form-control" ng-model="userInfo.brief"
                                      placeholder="请输入公司简介"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <input type="submit" class="btn btn-default" value="注  &nbsp;   册">
                            <%-- <button class="btn btn-default" ng-click="getFormData()">
                                 注  &nbsp;   册
                             </button>--%>

                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
