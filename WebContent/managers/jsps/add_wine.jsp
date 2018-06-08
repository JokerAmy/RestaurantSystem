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
		<input type="hidden" value="insertwine" name="type">
			
		<table>
			<tr>
				<td>酒水名称</td><td><input type="text" name="wine_name" ></td>
			</tr>
			
			<tr>
				<td>价格</td><td><input type="text" name="wine_price" ></td>
			</tr>
			<tr>
				<td>容量</td><td><input type="text" name="wine_capacity" ></td>
			</tr>
			<tr>
				<td>品牌</td><td><input type="text" name="wine_brand" ></td>
			</tr>
			
			<tr>
				<td>图片路径</td><td><input type="text" name="wine_img" ></td>
			</tr>
			
			<tr>
				<td><button type="submit" value="save" name="operation" id="findButton">确定</button></td>				
			</tr>
			
		</table>
	</form>
</body>
</html>