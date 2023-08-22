<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<center><h1>登录界面</h1></center>
	<form id="loginid" action="/web0515/web0515_01/class_cdx" method="post">
                <center><span>请输入root账号:</span><input type="text" name="account"><br></center>
                <center><span>请输入密码:</span><input type="password" name="mypassword"><br></center>
                <center><input type="submit" value="root登录"></center>
            </form>
            <br><br><br><br><br>
    <form id="loginid" action="/web0515/web0515_01/class_yh" method="post">
                <center><span>请输入管理员账号:</span><input type="text" name="account"><br></center>
                <center><span>请输入密码:</span><input type="password" name="mypassword"><br></center>
                <center><input type="submit" value="管理员登录"></center>
            </form>
            <br><br><br><br><br>
    <form id="loginid" action="/web0515/web0515_01/class_cust" method="post">
                <center><span>请输入用户账号:</span><input type="text" name="account"><br></center>
                <center><span>请输入密码:</span><input type="password" name="mypassword"><br></center>
                <center><input type="submit" value="用户登录/游客浏览"></center>
            </form>
            <br><br><br><br><br>
            <center><h2>注册 </h2></center>
            <form id="loginid" action="/web0515/web0515_01/class_zc" method="post">
                <center><span>请输入用户账号:</span><input type="text" name="account"><br></center>
                <center><span>请输入密码:</span><input type="password" name="mypassword"><br></center>
                <center><span>请输入称呼:</span><input type="text" name="name"><br></center>
                <center><input type="submit" value="注册账号"></center>
            </form>         
            
</body>
</html>