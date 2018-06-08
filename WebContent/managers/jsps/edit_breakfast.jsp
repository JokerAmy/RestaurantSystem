<%@page import="joker.models.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()
			+":"+request.getServerPort()+path+"/";
	
	String Maccount=(String)request.getSession().getAttribute("Maccount");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%Food food =(Food)request.getAttribute("food");%>
	
	<!-- base：将这个页面的路径定位到basePath -->
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Insert title here</title>
	<link rel="stylesheet" href="managers/css/font.css" />
	<link rel="stylesheet" href="managers/css/InputTextAndPwdSize.css" />
	<link rel="stylesheet" href="managers/css/findAndAddButton.css" />
	<style type="text/css">
	form{
		margin-top: 20px;
		margin-left: 20px;
	}
	td{
		margin-left: 10px;
		margin-top: 20px;
		padding: 10px;
	}
	</style>
</head>
<body>
	<!-- 显示异常信息 -->
	${exception}
	<form action="<%=request.getContextPath() %>/foodController" method="get">
		<input type="hidden" value="savedata" name="type">
		<input type="hidden" value=<%=food.get_FID() %>  name="id">
		
		<table>
			<tr>
				<td>菜肴名称</td><td><input type="text" name="food_name" value=<%=food.get_Fname()%>></td>
			</tr>
			
			<tr>
				<td>价格</td><td><input type="text" name="food_price" value=<%=food.get_Fprice() %>></td>
			</tr>
			<tr>
				<td>供应时间段</td><td><input type="text" name="food_time" value=<%=food.get_Ftime()%>></td>
			</tr>
			<tr>
				<td>菜肴种类</td><td><input type="text" name="food_type" value=<%=food.get_Ftype()%>></td>
			</tr>
			<tr>
				<td>图片地址</td><td><input type="text" name="food_image" value=<%=food.get_img()%>></td>
			</tr>
			
			<tr>
				<td><button type="submit" value="save" name="operation" id="findButton">保存</button></td>				
			</tr>
			
		</table>
	</form>
</body>
</html>