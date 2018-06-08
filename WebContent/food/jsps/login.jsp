<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()
			+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>">
	<meta charset="utf-8">
	<title>用户登陆</title>
	<style type="text/css">
	<!--
	#d1{
		
		text-align:center;
		margin-top:100px;
		width:100%;
		height:80%;
		}
	#d2{
		color:#030303;
		font-weight:bold;
		font-size:60px;
		
	}
	form
	{
		line-height:80px;
		padding:20px;
	}
	
	.i{
		text-align:center;
		height:50px;
		width:20%;
		border-radius:15px;
	}
	#s{
		background:white;
		border-radius:40px;
	}
	body 
	{
 		background-image: url(food/images/bg3.jpg);
 		background-size: cover;
 		background-repeat: no-repeat;
		color: black;
	}
	-->
	</style>
</head>
<body>

<div id="d1">
	<div id="d2">Wellcome</div>
	<p style="color:red">${error }</p>
	<form action="userController?type=login" method="Post"> 
	电话:<input type="text" name="uId" class='i' placeholder="请输入账号">
	<br>
	密码:<input type="password" name="uPaw" class="i" placeholder="请输入密码">
	<br>
	<input type="submit" name="login" value="登录" id="s" >
	</form>
	<a href="food/jsps/register.jsp">快速注册</a>
</div>

</body>
</html>