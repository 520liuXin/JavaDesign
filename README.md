
#  汽车租赁系统使用说明
系统启动步骤：
1.	本地安装数据结构服务器Redis并启动（未安装系统无法启动）；
2.	安装数据库，导入/db/Test.sql文件，并在src/main/resources/application.properties中修改数据库配置；
3.	启动系统，找到src/main/java/com/example/cy/CyApplication.java并启动；
4.	系统启动后，浏览器访问127.0.0.1:8888/login进入登录界面；
5.	用户登录（管理员账号：admin，密码：admin；用户账号：user，密码：user）；
6.	登录成功进入首页。

#  使用截图：
（1）主界面设计
汽车租赁系统主界面主要由三部分构成;主界面上方设置四个按钮，分别为“租车首页”，“最新资讯”，“商家中心”，个人中心。主界面中间为滚动的车辆图片显示，下方为车辆列表显示，首页提供搜索框可通过关键词查询车辆，同时搜索框下方设置四个按钮，分别为“本月爆款”，“猜你喜欢”，“最新上架”，“与众不同”，点击可推荐不同车辆供用户选择。具体效果图如下：

 
图 1 主界面截图1
![主界面截图1](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E9%A6%96%E9%A1%B5.png)


 
图 2 主界面截图2
![主界面截图2](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E9%A6%96%E9%A1%B5%20(2).png)


（2）车辆车辆详情界面
车辆详情界面主要显示车辆图片、车辆配置信息、租赁规则以及用户须知。同时设置电话联系和立即预约等按钮，方便用户操作。具体效果图如下：

 
图 3 车辆详情界面截图1
![车辆详情界面截图1](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E8%BD%A6%E8%BE%86%E8%AF%A6%E6%83%85%20(2).png)


 
图 4 车辆详情界面截图2
![车辆详情界面截图2](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E8%BD%A6%E8%BE%86%E8%AF%A6%E6%83%85.png)


（3）订单信息填写界面和支付返回界面
订单信息填写界面主要是对信息的填写，选择租赁起始时间和终止时间会实时生成订单总金额。
支付返回界面主要呈现支付状态以及设置两个超链接，点击可放回首页或个人中心查看订单。具体效果图如下：	 
图 5 订单信息填写界面截图
![订单信息填写界面截图](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E8%AE%A2%E5%8D%95.png)


图 6 支付界面截图
![支付界面截图](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/登录.png)


 
图 7 支付返回界面截图
![支付返回界面截图](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E6%94%AF%E4%BB%98%E6%88%90%E5%8A%9F.png)



（4）登录/注册界面
登录界面主要提供登录功能，界面中将提供三个文本框分别用来填写用户名，密码以及验证码，用户填写用户名，密码以及验证码后验证成功可完成登录。
注册界面设置多个文本框及按钮，主要填写用户名，用户密码，用户真实姓名，身份证号以及感兴趣标签的选择。具体效果图如下：

 
图 8 登录界面截图:
![登录界面](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/登录.png)


 
图 9 注册界面截图
![注册界面](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E6%B3%A8%E5%86%8C.png)



（5）管理中心界面
管理中心界面主要是对数据的显示，界面右上角设置四个按钮，分别为“订单管理”，“汽车管理”，“用户管理”，“数据中心”。具体效果图如下：

 
管理中心界面截图
 ![订单管理](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/登录.png)
 

 
![汽车管理](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E6%B1%BD%E8%BD%A6%E7%AE%A1%E7%90%86.png)


 
![用户管理](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E7%94%A8%E6%88%B7%E7%AE%A1%E7%90%86.png)


 

![数据中心1](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E6%95%B0%E6%8D%AE%E4%B8%AD%E5%BF%83.png)

![数据中心2](https://github.com/520liuXin/JavaDesign/blob/dev/src/main/resources/static/img/result/%E6%95%B0%E6%8D%AE%E4%B8%AD%E5%BF%83%20(2).png)