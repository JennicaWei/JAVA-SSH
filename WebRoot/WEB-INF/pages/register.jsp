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
						<h3>欢迎你</h3>
						<s:actionerror/><!-- 获取action的错误提示信息 -->
						<form action="userRegister" name="f" method="post" id="regForm">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="user.username" class="text" style="color:#FFFFFF !important"type="text" placeholder="请输入账户">
								</div>
			<div class="input_outer">
			<span class="us_uer"></span>
			<input name="user.password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
								<div class="input_outer">
								<span class="u_user"></span>
								<input name="password2" class="text" style="color: #FFFFFF !important" type="password" placeholder="确认密码">
								</div>
								<div class="input_outer" style="text-align: center;padding-top:10px;">
								 <input type="radio" name="user.sex" value="男"/>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="user.sex" value="女"/>女
								 </div>
								 <div class="input_outer">
								<span class="u_user"></span>
								<input name="user.birthday" class="text" style="color: #FFFFFF !important" type="text" placeholder="生日">
								</div>
								 <div class="input_outer">
								<span class="u_user"></span>
								<input name="user.idCard" class="text" style="color: #FFFFFF !important" type="text" placeholder="身份证号">
								</div>
								<div class="input_outer">
								<span class="u_user"></span>
								<input name="user.email" class="text" style="color: #FFFFFF !important" type="text" placeholder="电子邮箱">
								</div>
								<div class="input_outer">
								<span class="u_user"></span>
								<input name="user.moblie" class="text" style="color: #FFFFFF !important" type="text" placeholder="手机号码">
								</div>
								<div class="input_outer">
								<span class="u_user"></span>
								<input name="user.address" class="text" style="color: #FFFFFF !important" type="text" placeholder="地址">
								</div>
								 
							
							
							<div class="mb2"><a class="act-but submit" href="#" style="color: #FFFFFF" id="regBtn" onclick="reg()">注册</a></div>
							<div class="mb2"><a class="act-but submit" href="#" style="color: #FFFFFF" id="resetBtn" onclick="reset()">重置</a></div>
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
<script type="text/javascript">
	function reg(){
		document.getElementById("regForm").submit();
	}
	function reset(){
		document.getElementById("regForm").reset();
	}
</script>
	</body>
</html>
