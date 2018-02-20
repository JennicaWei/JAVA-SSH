<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%><!--引入Struts2的标签2-->

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>收藏</title>
    <link href="css/index.css" rel="stylesheet" type="text/css" />
	<link href="css/adv.css" rel="stylesheet" type="text/css" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script src="scripts/jquery-2.1.0.js" type="text/javascript"></script>
	<script src="scripts/adv.js" type="text/javascript"></script>
  </head>
  <body>
    <%@ include file="header.jsp" %>
   
	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; <a href="#">收藏商品</a> 
	</div>
	<div class="wrap">
		<div id="shopping">
			<form action="addCollect" method="post">
				<table>
					<tr>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>购买数量</th>
						<th>操作</th>
					</tr>
					<!-- 根据用户收藏生成列表 -->
					<s:iterator value="collectList" var="collect">
					<tr>
						<td class="thumb">
						<img style="width: 100px; height: 100px;" src="${collect.product.imgPath}" />
						<a href="product？id=${product.id }">${collect.product.name}</a></td>
						<td >
						<td class="price">
							￥<span id="span_1">${collect.product.price}</span>
					</td>
						<td class="delete"><a href="deleteCollect?id=${collect.id}">删除</a></td>
					</tr>
					</s:iterator>
				</table>
			</form>
		</div>
	</div>
  </body>
</html>
