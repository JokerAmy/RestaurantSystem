<%@page import="joker.models.User"%>

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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>		
		
		
		
		<style type="text/css">	
			body 
			{
 				background-image: url(food/images/bg2.jpg);
 				background-repeat: no-repeat;
 				background-size: cover;
				color: white;
			}
			#head div{ font-size: 60px; text-align:center}
			#login {font-size: 20px;}
			#register {font-size: 20px;}
			#VIP {font-size:20px;}
			#unlogin{font-size:20px;}
			#login, #register,#VIP,#unlogin{ float: right; margin-top: -20px; }
			#left a {font-size:40px}
			
			
		</style>
	</head>
	<body>
		<div id="main">
			<div id="head"><div>醉仙楼&nbsp;&nbsp;</div></div>
			<div id="login"><a href="food/jsps/register.jsp" class="hover" style="text-decoration:none;color:white;">[注册]</a></div>
			<div id="register"><a href="food/jsps/login.jsp" class="hover" style="text-decoration:none;color:white;">[登陆]</a></div>
			<div id="VIP"><a href="sys/validateLogin" class="hover" style="text-decoration:none;color:white;">[会员中心]</a></div>	
			<div id="unlogin"><a href="userController?type=unlogin" class="hover" style="text-decoration:none;color:white;">[退出当前账户]</a></div>	
		</div>
		
		
		<div id="left">
				
						<br></br>
						
						<a href="displayFoodController?type=displaybreakfast" class="hover" style="text-decoration:none;color:white;">早餐</a>
						
						
						<br></br>
						<br></br>
						
						<a href="displayFoodController?type=displaylunch" class="hover" style="text-decoration:none;color:white;">中餐</a>
						
						<br></br>
						
						<br></br>	
						<a href="displayFoodController?type=displaydinner" class="hover" style="text-decoration:none;color:white;">晚餐</a>
						
					
						<br></br>	
						<br></br>	
						<a href="displayFoodController?type=displaywine" class="hover" style="text-decoration:none;color:white;">酒类</a>
						<br></br>	
						<br></br>	
						<a href="orderController?type=displayorderform" class="hover" style="text-decoration:none;color:white;">我的订单</a>
						<br></br>	
						<br></br>
						<a href="orderController?type=displayorderform" class="hover" style="text-decoration:none;color:white;">个人信息</a>
				
				
		</div>	
		
		
	</body>
</html>