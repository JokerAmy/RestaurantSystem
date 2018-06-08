<%@page import="joker.models.User"%>
<%@page import="java.util.List"%>
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
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<%/*List<Food> foods =(List<Food>)request.getAttribute("FoodList"); 
		*/
	
	%>
 <style>
  	*{margin:0;padding:0;}
	body{font-family:tahoma,"微软雅黑","宋体",serif;font-size:12px}
	ul{list-style:none;}

	.food-list{border:1px ;width:1090px;}
		.food-list li{width:200px;padding:3px;border:1px #eee solid;float:left;margin-right:10px;margin-bottom:10px;}
			
			.food-list li h5{color:#D00104;font-size:20px;text-align:center}
			.food-list li h5 span {font-size:12px;}
			.food-list li p {height:24px;overflow:hidden;line-height:24px;}
				.food-list li a{color:#333;text-decoration:none;}
				.food-list li a:hover{color:#CD0306;text-decoration:underline;}
			#zhou img{ width: 200px; height: 200px; border-radius: 10px;}
			#good{ float: left; cursor: pointer; }
			#good img{ width: 20px; height: 20px; }
			.food-name{ display: block; margin-left: 90px; font-size:20px}

		.food-list li:hover{border-color:#B10000}
		
  </style>
 </head>
 <body>
 	<a href="food/jsps/user_index.jsp">返回</a>
 	<%List<Food> foods =(List<Food>)request.getAttribute("foodlist"); 
 		User user=(User)request.getSession().getAttribute("user");
 		
 	%>		
	<ul class="food-list" >
		<%for (Food food:foods ){%>
		<li>
			<%String adress="food/images/"+food.get_img(); %>
			<a href="#" title="食品详情" > <div id="zhou"><img src=<%=adress%> alt="食品"></div></a>
			<h5><span>￥</span><%=food.get_Fprice() %></h5>
			<div>
				<div id="good"><a  href="orderController?type=bookfood&foodid=<%=food.get_FID() %>" title="加入订单"  onclick="_click()">
				<img src="food/images/shopping_icon.png" alt="食品"></a></div>
				
				<span class="food-name"><a href="#"><%=food.get_Fname()%></a></span>
			</div>
		</li>
		<%} %>
		
 </ul>
 		<script type="text/javascript">
			function _click()
			{
				
					
					
				alert("订餐成功");
				
					
				
				
				
				
			}
			
		
		</script>
 </body>
</html>
