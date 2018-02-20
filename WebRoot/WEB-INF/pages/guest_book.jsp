<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户留言</title>
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
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; <a href="#">百货</a> &gt; <a	href="#">家居</a>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<!--商品分类-->
			<div class="p_category">
				<h2>商品分类</h2>
				<dl>
					<dt><a href="#">品牌</a></dt>
					<dd><a href="#">鞋包</a></dd>
					<dd><a href="#">玩具文具</a></dd>
					<dd><a href="#">汽车用品</a></dd>
				</dl>
				<dl>
					<dt><a href="#">图音</a></dt>
					<dd><a href="#">qq</a></dd>
					<dd><a href="category?cate=child&amp;hpcId=4">音乐</a></dd>
				</dl>
			</div>
			<!--商品分类结束-->
			<div class="pre_look">
				<h3>最近浏览</h3>
				<dl>
					<dt>
						<img style="width: 54px; height: 54px;" src="images/product/2.jpg" />
					</dt>
					<dd>
						<a href="#">乐扣普通型保鲜盒圣诞7件套</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="main">
			<div class="guest_book">
				<h2>全部留言</h2>
				<s:iterator value="guestAllList" var="guestAll">
				<ul>
					<li>
						<dl>
							<dt>留言标题：${guestAll.title}</dt>
							<dd class="author"><span>作者：${guestAll.name}</span></dd>
							<dd>留言时间：${guestAll.guestTime}</dd>
							<dd>留言内容：${guestAll.message}</dd>
						</dl>
					</li>
				</ul>
				</s:iterator>
				<div class="clear"></div>
				<div class="pager">
					<ul class="clearfix">
					</ul>
				</div>
				<div id="reply-box">
					<form action="addGuest" method="post">
						<table>
							<tr>
								<td class="field">昵称：</td>
								<td><input class="text" type="text" name="guestName" /></td>
							</tr>
							<tr>
								<td class="field">留言标题：</td>
								<td><input class="text" type="text" name="guestTitle" /></td>
							</tr>
							<tr>
								<td class="field">留言内容：</td>
								<td><textarea name="guestContent"></textarea></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
  </body>
</html>
