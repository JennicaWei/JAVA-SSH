<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %><!-- 引入struts2的标签库 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" class="no-js">
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
						<h3>欢迎你</h3>
						<s:actionerror/>
						<form action="" name="f" method="get">
							<div class="input_outer">
								<span class="u_user"></span>
								<input id="un" name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input id="pw" name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2"><a class="act-but submit" href="javascript:lg();" style="color: #FFFFFF">登录</a></div>
						</form>
						
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script type="text/javascript">
							function lg(){
								var username =	document.getElementById("un").value;
								var password =  document.getElementById("pw").value;
								window.location.href="userlogin?username="+username+"&password="+password;
							};
						</script>
		<script src="assets/js/TweenLite.min.js"></script>
		<script src="assets/js/EasePack.min.js"></script>
		<script src="assets/js/rAF.js"></script>
		<script src="assets/js/demo-1.js"></script>
		<div style="text-align:center;">

</div>
	</body>
</html>