<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> <!--引入Struts2的标签库-->

 <div id="header">
		<div class="login_menu">
			<div class="login_container">
				<ul class="m_left">
					<s:if test="#session.loginUser!=null">
					<li><a href="#" class="c_red">${loginUser.username }</a>&nbsp;&nbsp;&nbsp;</li>
					<li><a href="logout">退出</a></li>
					</s:if>
					<s:if test="#session.loginUser==null">
					<li><a href="login" class="c_red">请登录</a>&nbsp;&nbsp;&nbsp;</li>
					<li><a href="register">请注册</a></li>
					</s:if>
				</ul>
	
				<ul class="m_right">
				
					<li><img src="images/icon_3.png"><a href="listCart"	class="c_red">购物车</a></li>
					<li><img src="images/icon_4.png"><a	href="listOrder">我的订单</a></li><!--listOrder-->
					<li><img src="images/icon_2.png"><a href="guest_book">留言</a></li>
					<li><img src="images/icon_1.png"><a href="index">首页</a></li>
					<li><img src="images/icon_2.png"><a href="listCollect">收藏</a></li>
					
				</ul>
			</div>
		</div>
		<div class="logo_search">
			<div class="logo">
				<img src="images/LOGO.png">
			</div>
			<div class="search">
			<form action="search">
				<input type="text" placeholder="输入宝贝的名称关键字" name="keyword" id="qname" />
				<button class="query_button" type="submit">搜索</button>
				</form>
			</div>
		</div>
		<div class="nav_bar">
			<div class="nav_bar_container">
				
			</div>
		</div>
	</div>