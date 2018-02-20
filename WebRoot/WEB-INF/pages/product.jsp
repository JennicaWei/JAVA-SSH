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
    <title>商品详情-${product.name}</title>
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
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; 
		<a href="#">${product.category.parent.name}</a> &gt; 
		<a	href="#">${product.category.name}</a>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<!--商品分类-->
			<div class="p_category">
				<h2>商品分类</h2>
				<!--遍历顶级分类-->
				<s:iterator value="categoryList" var="category">
				<dl>
					<dt><a href="#">${category.name}</a></dt>
					<!--遍历二级分类-->
					<s:iterator value="#category.categories" var="subCategory">
					<dd><a href="#">${subCategory.name}</a></dd>
				</s:iterator>
				</dl>
				</s:iterator>
			</div>
			<!--商品分类结束-->
			<div class="pre_look">
				<h3>最近浏览</h3>
				
				<dl>
					<dt>
						<img style="width: 54px; height: 54px;" src="${product.imgPath}" />
					</dt>
					<dd>
						<a href="product?id=${product.id}">${product.name}</a>
					</dd>
				</dl>
			
			</div>
		</div>
		<div id="product" class="main">
			<h1>商品名称:${product.name}</h1>
			<div class="infos">
			<form action="addCart">
			<input type="hidden" name="productId" value="${product.id }"/><!--隐藏域，存放商品id-->
				<div class="thumb">
					<img style="width: 100px; height: 100px;" src="${product.imgPath}" />
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price">￥${product.price}</span>
					</p>
					<p>
						库 存：<span id="stock">${product.stock}</span>(有货)
					</p>
					<input type="button" id="minus" value=" - " width="3px"> 
					<input type="text" id="count" name="quantity"  value="1" maxlength="5" size="1" style="text-align: center; vertical-align: middle">
					<input type="button" id="add" value=" + " width="2px" onclick="add();">
					<div class="button">
							<input type="button" name="button" value="" style="background: url(images/buyNow.png)" /> 
							<input type="image"name="imageField" src="images/cartbutton.png" />
							
							<a href="addCollect?productId=${product.id }">收藏商品</a>
								
					</div>
				</div>
				</form>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text">
					商品名字：${product.name}<br /> 商品描述：${product.describe}<br />
					商品价格：￥${product.price}<br /> 商品库存：${product.stock}<br />
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
  </body>
</html>
