<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2018/5/4
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>后台管理</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login_box">
    <div class="login_l_img"><img src="images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
        <div class="login_name">
            <p>后台管理系统</p>
        </div>
        <form method="post" action="/login.shtml">
            <input name="username" type="text"  value="用户名" >
            <input name="password" type="password" id="密码" />
            <input value="登录" style="width:100%;" type="submit">
        </form>
        <div>${error}</div>
    </div>
    <div class="copyright">民生集团 版权所有©2016-2018 技术支持电话：000-00000000</div>
</div>
</body>
</html>
