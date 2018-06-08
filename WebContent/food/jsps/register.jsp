<%@page import="joker.models.Food"%>
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
	
	
	
	<!-- base：将这个页面的路径定位到basePath -->
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Insert title here</title>
	<link rel="stylesheet" href="food/css/font.css" />
	<link rel="stylesheet" href="food/css/InputTextAndPwdSize.css" />
	<link rel="stylesheet" href="food/css/findAndAddButton.css" />
	<style type="text/css">
		form
		{
			margin-top: 20px;
			margin-left: 20px;
		}
		td{
			margin-left: 10px;
			margin-top: 20px;
			padding: 10px;
		}
		body 
			{
 				background-image: url(food/images/bg3.jpg);
 				background-size: cover;
 				background-repeat: no-repeat;
				color: black;
			}
	</style>
</head>
<body>
	<!-- 显示异常信息 -->
	${exception}
	<form action="userController?type=register" method="post">
		<input type="hidden" value="register" name="type">	
		<table>
			<tr>
				<td>昵称</td><td><input type="text" onclick="check(this)" name="user_name" ></td>
			</tr>
			
			<tr>
				<td>电话号码</td><td><input  type="text" onclick="check(this)" name="user_phone" ></td>
			</tr>
			<tr>
				<td>密码</td><td><input  type="password" onclick="check(this)" name="user_password" ></td>
			</tr>
			<tr>
				<td>再次输入密码</td><td><input  type="password" onclick="check(this)" name="user_password_again" ></td>
			</tr>
			
			<tr>
				<td><button type="submit" value="save" name="operation" id="findButton">注册</button></td>				
			</tr>
			
		</table>
	</form>
	<script type="text/javascript">  
    	function get(obj)
    	{  
        	
        	var radio = obj;
        	if(radio.value=="1")
        	{
        		
        	}
        	else if(radio.value=="0")
        	{
        		
        	}
        	
        	
    		//alert(radio.value);  
    	}  
    	function check(obj)
    	{
    		
    		
    	}
    	
	</script>  
</body>
</html>