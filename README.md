# Ranger
订单状态：
+ 1 待确认（待提交游客信息）
+ 11 待提交确认单
+ 12 待回执确认单
+ 2 待付款
+ 3 已付定金*
+ 4 已付款
+ 5 已完成
+ 6 已评价
+ 7 已取消

##FilePathUtil
1. FilePathUtil.convert()函数可以将路径中的文件分隔符转换为适合本机的。
2. resources目录下imageroot.cfg文件中的数据是所有图片的根目录(web目录下images下)
3. 如果数据库里面存的是相对于该根目录的路径,调用getRealImagesPath()得到图片在web文件夹下的路径。

```
relativeImagePath = ...//从数据库里取出来的路径 
String imagePath = FilePathUtil.getInstance().getRealImagesPath(relativeImagePath);
```

4. 如果数据库里直接存的是相对于web文件夹的路径,只调用FilePathUtil.convert()函数将路径中的文件分隔符转换为适合本机的即可。(由于目测数据库中存的都是images/XX),所以以上两条基本没什么用。