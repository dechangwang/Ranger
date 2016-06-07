'use strict';

rangerApp.controller('notificationCtrl', ['$scope', '$http', 'Angency', '$window',
    function ($scope, $http, Angency, $window) {

       /* var ceshi = {
            orderId: 12,
            amount: 250.00,
            buyerId: 233,
            payPass: 'lshsaji'
        };
        $http({
            url: '/Ranger/api/trade/pay',
            method: 'POST',
            data: ceshi
        }).then(function (response) {
            console.log(response.data);
            alert(response.data);
        }, function (err) {
            console.log(err.data);
            alert(err.data);
        });*/
        //==========================
        $scope.pageNumber = function () {
            var angencyId = $window.sessionStorage.angencyId;
            var mUrl = '/Ranger/api/notification/pageNumber/'+angencyId+'?type='+$scope.type;
            $http({
                url: mUrl,
                method: 'GET'
            }).then(function (response) {
                $scope.maxPage = response.data;
                if ($scope.maxPage === 0)
                    $scope.maxPage = 1;
            }, function (err) {
                //nothing
            })
        };

        var angencyId = $window.sessionStorage.angencyId;
        var mUrl = '/Ranger/api/notification/unread/' + angencyId + '?page=1';
        $http({
            url: mUrl,
            method: 'GET'
        }).then(function (response) {
            $scope.notis = response.data;
        }, function (err) {
            alert("获取失败  " + err);
        });
        $scope.type = 'unread';
        $scope.pageNumber();
        $scope.maxPage = -1;
        $scope.cPage = 1;
        // $('#unread').style.background="#99FFFF";

        $scope.changeType = function (event) {
            //按钮颜色
            var x = event.currentTarget;
            var id = x.id;
            $scope.type = id;
            $scope.pageNumber();
            var children = $('#filter-container').children();
            for(var i = 0; i < children.length; i++) {
                var y = children[i];
                if (y.id !== id) {
                    y.style.background="";
                }
            }
            x.style.background="#99FFFF";
            //页码
            $scope.cPage = 1;
            //url
            var angencyId = $window.sessionStorage.angencyId;
            var mUrl = '/Ranger/api/notification/'+$scope.type+'/'+angencyId+'?page='+$scope.cPage;
            $http({
                url: mUrl,
                method: 'GET'
            }).then(function (response) {
                $scope.notis = response.data;
            }, function (err) {
                alert("获取失败  " + err.data);
            });
        };

        $scope.changePage = function (page) {
            if (page < 1)
                page = 1;
            if (page > $scope.maxPage)
                page -= 1;
            /*if ($scope.maxPage > 0) {
                if (page > $scope.maxPage)
                    page = $scope.maxPage;
            }*/
            //页码
            $scope.cPage = page;
            //url
            var angencyId = $window.sessionStorage.angencyId;
            var mUrl = '/Ranger/api/notification/'+$scope.type+'/'+angencyId+'?page='+$scope.cPage;
            $http({
                url: mUrl,
                method: 'GET'
            }).then(function (response) {
                $scope.notis = response.data;
                /*if (response.data.length === 0) {
                    if ($scope.cPage != 1) {
                        $scope.cPage -= 1;
                    }
                    $('#previous').click();
                    $scope.maxPage = $scope.cPage;
                }*/
            }, function (err) {
                alert("获取失败  " + err.data);
            });
        };

        $scope.setViewed = function (nid) {
            var mUrl = '/Ranger/api/notification/setviewed/' + nid;
            $http({
                url: mUrl,
                method: 'GET'
            }).then(function (response) {
                var re = response.data;
            }, function (err) {
                alert(err.data);
            });
        };

        $scope.unread = function (event) {
            var x = event.currentTarget;
            var id = x.id;
            var children = $('#filter-container').children();
            for(var i = 0; i < children.length; i++) {
                var y = children[i];
                if (y.id !== id) {
                    y.style.background="";
                }
            }
            x.style.background="#99FFFF";
            var angencyId = $window.sessionStorage.angencyId;
            var mUrl1 = '/Ranger/api/notification/unread/' + angencyId;
            $http({
                url: mUrl1,
                method: 'GET'
            }).then(function (response) {
                $scope.notis = response.data;
                /*for (var i = 0; i < $scope.notis.length; i++) {
                    var time = $scope.notis[i].generateTime;
                    $scope.notis[i].generateTime = new Date(time);
                }*/
            }, function (err) {
                alert("获取失败  " + err.data);
            });
        };
        $scope.read = function (event) {
            var x = event.currentTarget;
            var id = x.id;
            var children = $('#filter-container').children();
            for(var i = 0; i < children.length; i++) {
                var y = children[i];
                if (y.id !== id) {
                    y.style.background="";
                }
            }
            x.style.background="#99FFFF";
            var angencyId = $window.sessionStorage.angencyId;
            var mUrl2 = '/Ranger/api/notification/read/' + angencyId;
            $http({
                url: mUrl2,
                method: 'GET'
            }).then(function (response) {
                $scope.notis = response.data;
                /*for (var i = 0; i < $scope.notis.length; i++) {
                    var time = $scope.notis[i].generateTime;
                    $scope.notis[i].generateTime = new Date(time);
                }*/
            }, function (err) {
                alert("获取失败  " + err.data);
            });
        };
        $scope.all = function (event) {
            var x = event.currentTarget;
            var id = x.id;
            var children = $('#filter-container').children();
            for(var i = 0; i < children.length; i++) {
                var y = children[i];
                if (y.id !== id) {
                    y.style.background="";
                }
            }
            x.style.background="#99FFFF";
            var angencyId = $window.sessionStorage.angencyId;
            var mUrl3 = '/Ranger/api/notification/all/' + angencyId;
            $http({
                url: mUrl3,
                method: 'GET'
            }).then(function (response) {
                $scope.notis = response.data;
                /*for (var i = 0; i < $scope.notis.length; i++) {
                    var time = $scope.notis[i].generateTime;
                    $scope.notis[i].generateTime = new Date(time);
                }*/
            }, function (err) {
                alert("获取失败  " + err.data);
            });
        };
    }]);

