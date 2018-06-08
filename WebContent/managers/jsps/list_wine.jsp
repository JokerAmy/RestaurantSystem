<%@page import="joker.models.Wine"%>
<%@page import="java.util.List"%>


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
	
	List<Wine> wines =(List<Wine>)request.getAttribute("wines");
	//request.setAttribute("foods", foods);
	%>
	<div id="right">
		<form action="<%=request.getContextPath() %>/foodController" method="get">
			酒水名称：<input type="text" name="foodname" value="${_Fname}">&nbsp;
			<button type="submit" value="findFood" name="type" id="findButton">查寻</button>&nbsp;
			<button type="submit" value="toAddWine" name="type" id="addButton">新增酒水</button>
		</form>
		<table class="mvManagementTable">
			<tr>
				<th>酒水编号</th><th>酒水名称</th><th>价格</th><th>品牌</th><th>操作</th><th>删除</th>
			</tr>
			
			<%for (Wine wine :wines){ %>
			<tr>
				
				<td><%=wine.get_id()%></td>
				<td><%=wine.get_name()%></td>
				<td><%=wine.get_price()%></td>
				<td><%=wine.get_brand()%></td>
				
				<td><a href="foodController?type=editwine_<%=wine.get_id()%>">编辑</a></td>
				<td><a href="foodController?type=deletewine_<%=wine.get_id()%>">删除</a></td>
			</tr>
			<%}%>
			
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