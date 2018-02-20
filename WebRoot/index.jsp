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
  </head>
  <body>
                         首页. <br>
        <!--使用s:if标签判断session里的key为loginuser的值是否为null-->
        <s:if test="#session.loginUser==null">
        <p style="color:red;">用户未登陆</p>
     <a href="login" target="_blank">登陆</a>|<a href="register" tager="_blank">注册</a>
      </s:if>
      <s:if test="#session.loginUser!=null">
       <p style="color:green;">用户已登陆:用户名：${loginUser.username}</p>
      <a href="user/list">查看用户列表</a>
       </s:if>
  </body>
</html>
