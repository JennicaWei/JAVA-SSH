<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> <!--引入Struts2的标签库-->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>购物车</title>
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
			<form action="createOrder" method="post">
				<table>
					<tr>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>购买数量</th>
						<th>操作</th>
					</tr>
					<!-- 根据用户购物车生成列表 -->
					<s:iterator value="cartList" var="cart">
					<tr>
						<td class="thumb">
						<img style="width: 100px; height: 100px;" src="${cart.product.imgPath }" />
						<a href="#">${cart.product.name}</a>
						</td>
						<td class="price" >
							￥<span id="span_1">69.0</span>
						</td>
						<td class="number">
								<input type="button" id="minus"value=" - " width="3px" onclick=" reduce(1)" name="minusButton">
								<input id="1" type="text" name="pro${product.id}" value="${cart.quantity}" maxlength="5" size="1"  style="text-align:center; vertical-align:middle" />
								<input type="button" id="add" value=" + " width="2px"  name="addButton">		
						</td>
						<td class="delete"><a href="deleteCart?id=${cart.id }">删除</a></td>
					</tr>
					</s:iterator>
				</table>
				<div class="button"><input type="submit" value="" /></div>
			</form>
		</div>
	</div>
  </body>
</html>
