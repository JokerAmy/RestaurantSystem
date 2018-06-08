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
	<title>1</title>
	<style type="text/css">
	<!--
	#d1{
		background:rgb(134,137,187);
		text-align:center;
		margin-top:100px;
		width:100%;
		height:80%;
	}
	#d2{
		color:#ffffff;
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
		background:yellow;
		border-radius:20px;
	}
	
	-->
	</style>
</head>
<body>

<div id="d1">
<div id="d2">Manager</div>
	<p style="color:red">${error }</p>

<form action="managerController" method="Post"> 
	<input type="text" name="uId" class='i' placeholder="请输入账号">
	<br>
	<input type="password" name="uPaw" class="i" placeholder="请输入密码">
	<br>
	<input type="submit" name="login" value="登录" id="s" >
</form>
</div>
<script type="text/javascript" language="javascript">  
  function validateLogin()
  {  
    var sUserName = document.frmLogin.uId.value ;  
    var sPassword = document.frmLogin.uPaw.value ;  
   // var sinputCode =document.frmLogin.inputcode.value ;    
    if ((sUserName =="") || (sUserName=="Your name"))
    {  
     alert("请输入用户名!");  
     return false ;  
    }  
       
    if ((sPassword =="") || (sPassword=="Your password"))
    {  
     alert("请输入密码!");  
     return false ;  
    }  
  }
  </script>  
</body>
</html>