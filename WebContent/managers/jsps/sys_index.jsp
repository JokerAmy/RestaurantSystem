 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()
			+":"+request.getServerPort()+path+"/";
	
	String Maccount=(String)request.getSession().getAttribute("Maccount");
	if(Maccount==null||Maccount.equals(""))
	{
		response.sendRedirect("m_index.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="managers/css/font.css" />
		<link rel="stylesheet" href="managers/css/hover.css" />
		<link rel="stylesheet" href="managers/css/sys_index.css" />
		<script src="managers/js/sys_index.js"></script>
	</head>
	<body>
		<div id="main">
			<div id="head"><div>欢迎您，admin&nbsp;&nbsp;<a href="sys/validateLogin" class="hover" style="text-decoration:none;color:black;">[退出]</a></div></div>
			<div id="title"><div><img src="managers/images/manager.png" /><span>系统管理</span></div></div>
			<div id="content">
			<div id="left">
				<ul>
						<li>早餐管理</li>
						<li>中餐管理</li>
						<li>晚餐管理</li>
						<li>会员管理</li>
						<li>酒水管理</li>
				</ul>
				
			</div>		
				<div id="topBar"><img src="managers/images/playButtom.jpg" /></div>		
				<iframe name="right" id="right" frameborder="0">
				</iframe>
			</div>
		</div>
	</body>
</html>