<%@page import="java.util.List"%>
<%@page import="joker.JdbcUtils.PageBean"%>
<%@page import="joker.models.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page import="java.util.Date"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()
			+":"+request.getServerPort()+path+"/";
	
	String Maccount=(String)request.getSession().getAttribute("Maccount");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- base：将这个页面的路径定位到basePath -->
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="managers/css/font.css" />
	<link rel="stylesheet" href="managers/css/hover.css" />
	<link rel="stylesheet" href="managers/css/InputTextAndPwdSize.css" />
	<link rel="stylesheet" href="managers/css/findAndAddButton.css" />
	<link rel="stylesheet" href="managers/css/target.css">
	<script src="managers/js/target.js"></script>
</head>
<body>
<%
	
	List<Food> foods =(List<Food>)request.getAttribute("FoodList");
	//request.setAttribute("foods", foods);
	%>
	<div id="right">
		<form action="<%=request.getContextPath() %>/foodController" method="get">
			菜肴名称：<input type="text" name="foodname" value="${_Fname}">&nbsp;
			<button type="submit" value="findFood" name="type" id="findButton">查寻</button>&nbsp;
			<button type="submit" value="toAdd" name="type" id="addButton">新增菜肴</button>
		</form>
		<table class="mvManagementTable">
			<tr>
				<td>菜肴编号</td><td>菜肴名称</td><td>价格</td><td>供应时间段</td><td>操作</td><td>删除</td>
			</tr>
			
			<%for (Food food :foods){ %>
			<tr>
				
				<td><%=food.get_FID()%></td>
				<td><%=food.get_Fname()%></td>
				<td><%=food.get_Fprice()%></td>
				<td><%=food.get_Ftime()%></td>
				
				<td><a href="foodController?type=editfood_<%=food.get_FID()%>">编辑</a></td>
				<td><a href="foodController?type=delete_<%=food.get_FID()%>">删除</a></td>
			</tr>
			<%} %>
			
		</table>
		<form class="page" action="sys/MVOnListServlet" method="get">
			<input type="hidden" value="${isSearchingPage }" name="isSearchingPage">
			<input type="hidden" value="${mv_name }" name="mv_name">
			<button type="submit" value="lastPage" name="type" style="background-color:${currentPage2==1?'gray':'blue'}">上一页</button>
			<input type="text" value="${currentPage2}/${maxPage2}" name="page" readonly="readonly">
			<button type="submit" value="nextPage" name="type" style="background-color:${currentPage2==maxPage2?'gray':'blue'}">下一页</button>
			<input type="text" name="goToPage">
			<button type="submit" value="goToPage" name="type">跳转</button>
		</form>
	</div>
</body>
</html>