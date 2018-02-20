<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新闻详情</title>
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
		<div class="left-side">
			<div class="newsList">
					<h2>新闻动态</h2>
					<ul>
						<s:iterator value ="newsList" var="news2">
						<li><a href="newsDetail?id=${news2.id }">${news2.title }</a></li>
						</s:iterator>
					</ul>
				</div>
		</div>
		<div id="news" class="right-main">
			<h1>标题：${news.title }</h1>
			<div class="content">
				<p style="text-align: right;">创建时间：${news.createTime}</p>
				内容：${news.news}	
			</div>
		</div>
		<div class="clear"></div>
	</div>
  </body>
</html>
