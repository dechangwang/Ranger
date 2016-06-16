##### 浏览器缩小时 图片布局变乱
*在bootstrap.min.css中作如下修改*
```
//大概在1181行 原先min-width:900px
@media (min-width: 200px) {
    .col-md-1, .col-md-2, .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-md-10, .col-md-11, .col-md-12 {
        float: left
    }
```
##### 导航栏布局变乱
*在bootstrap.min.css中作如下修改
```
//大概在4121行
@media (min-width: 768px) {

}
.navbar-nav {
    float: left;
    margin: 0
}

.navbar-nav > li {
    float: left
}

.navbar-nav > li > a {
    padding-top: 15px;
    padding-bottom: 15px
}

.navbar-nav.navbar-right:last-child {
    margin-right: -15px

```