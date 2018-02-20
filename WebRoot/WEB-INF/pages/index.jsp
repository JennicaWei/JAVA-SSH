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
    <title>首页</title>
    <link href="css/index.css" rel="stylesheet" type="text/css" />
	<link href="css/adv.css" rel="stylesheet" type="text/css" />
	<script src="scripts/jquery-2.1.0.js" type="text/javascript"></script>
	<script src="scripts/adv.js" type="text/javascript"></script>
	<script type="text/javascript" src="scripts/function.js"></script>
	<script type="text/javascript" src="scripts/index.js"></script>
  </head>
  <body>
  <!--导入外部头部jsp-->
  <%@ include file="header.jsp" %>  
	<div id="middle">
		<div class="p_left">
			<!--商品分类-->
			<div class="p_category">
				<h2>商品分类</h2>
				<!--遍历顶级分类-->
				<s:iterator value="categoryList" var="category">
				<dl>
					<dt><a href="#">${category.name}</a></dt>
					<!--遍历二级分类-->
					<s:iterator value="#category.categories" var="subCategory">
					<dd><a href="search?categoryId=${subCategory.id}">${subCategory.name}</a></dd>
				</s:iterator>
				</dl>
				</s:iterator>
				<a href="index"><input type="button"></input></a>
			</div>
			<!--商品分类结束-->
			<div class="pre_look">
				<h3>最近浏览</h3>
				<!-- 遍历productList -->
				<s:iterator value="#session.ProducBrowtList" var="product">
				<dl>
					<dt>
						<img style="width: 54px; height: 54px;" src="${product.imgPath}" />
					</dt>
					<dd>
						<a href="product?id=${product.id}">${product.name}</a>
					</dd>
				</dl>
				</s:iterator>
			</div>
		</div>
		<div class="p_center">
			<div id="wrapper">
				<div id="focus">
					<ul>
						<li><a href="#"><img src="images/T1.jpg" /></a></li>
						<li><a href="#"><img src="images/T2.jpg" /></a></li>
						<li><a href="#"><img src="images/T3.jpg" /></a></li>
						<li><a href="#"><img src="images/T4.jpg" /></a></li>
						<li><a href="#"><img src="images/T5.jpg" /></a></li>
					</ul>
				</div>
			</div>
			<div class="p_list">
				<div class="p_info">
					<img src="images/icon_sale.png"/>商品列表 
				</div>
			</div>

			<ul class="product2">
				<!-- <h4>找不到您搜索的商品！</h4> -->
				<s:iterator value="productList" var="product">
				<li>
					<dl>
						<dt><a href="product?id=${product.id}" target="_self"><img src="${product.imgPath}"></a></dt>
						<dd class="title">
							<a href="product?id=${product.id}" target="_self">${product.name}</a>
						</dd>
						<dd class="price">￥${product.price}</dd>
					</dl>
				</li>
				</s:iterator>
			</ul>
		</div>

		<div id="p_right">
			<div class="newsList">
				<h2>新闻动态</h2>
				<ul>
				<s:iterator value="newsList" var="news2">
					<li><a href="newsDetail?id=${news2.id }">${news2.title }</a></li>
				</s:iterator>	
				</ul>
			</div>
			<div class="hot_sale">
				<h2>热卖推荐</h2>
				<ul>
					<li>
						<dl>
							<dt>
								<a href="#" target="_self"><img src="images/product/2.jpg" /></a>
							</dt>
							<dd class="p_name">
								<a href="#" target="_self">乐扣普通型保鲜盒圣诞7件套</a>
							</dd>
							<dd class="price">￥69.0</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
	</div>
  </body>
</html>
