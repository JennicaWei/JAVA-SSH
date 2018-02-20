<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %><!-- 引入struts2的标签库 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="assets/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="assets/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="assets/css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
  </head>
  
  <body>
  <div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>注册成功！</h3>
						<s:actionerror/><!-- 获取action的错误提示信息 -->
    
  <br>
<form action="login" method="post">
 <div class="mb2"><a class="act-but submit" href="login" style="color: #FFFFFF">立即登陆</a></div>
 </form>
<form action="index" method="post">
 <div class="mb2"><a class="act-but submit" href="index" style="color: #FFFFFF" >回到首页</a></div>
  </form>
</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="assets/js/TweenLite.min.js"></script>
		<script src="assets/js/EasePack.min.js"></script>
		<script src="assets/js/rAF.js"></script>
		<script src="assets/js/demo-1.js"></script>
		<div style="text-align:center;">

</div>
</body>
</html>
