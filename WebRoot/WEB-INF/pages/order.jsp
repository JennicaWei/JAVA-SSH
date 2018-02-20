<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>订单页</title>
    <link href="css/index.css" rel="stylesheet" type="text/css" />
	<link href="css/adv.css" rel="stylesheet" type="text/css" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script src="scripts/jquery-2.1.0.js" type="text/javascript"></script>
	<script src="scripts/adv.js" type="text/javascript"></script>
  </head>
  <body>
    <!--导入外部头部jsp-->
  <%@ include file="header.jsp" %>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; <a href="#">购物车</a> 
	</div>
	<div class="wrap">
		<div id="shopping">
			<s:iterator value="orderList" var="order">
				<table id="oderview">
					<tr>
						<th>订单时间:${order.createTime}</th>
						<th>订单号:${order.id}</th>
						<th>订单总额:${order.total}</th>	
						<th><th>				
					</tr>
					<s:iterator value="#order.orderItems" var="orderItem">
					<tr>
						<td class="thumb">
						<img style="width: 100px; height: 100px;" src="${orderItem.product.imgPath}" />
						<a href="#">${orderItem.product.name}</a></td>
						<td class="price" >
							￥<span >单价：${orderItem.product.price}</span>
						</td>
						<td class="number">
								<span>X${orderItem.quantity}</span>
						</td>
						<td class="delete">正在发货</td>
					</tr>
					</s:iterator>
				</table>
				</s:iterator>
		</div>
	</div>
  </body>
</html>
