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
    
    <title>用户列表</title>
  </head>
  <body>
  当前登陆用户：<span style="color:red;">${loginUser.username}</span>
   <table border="1" width="600">
   <caption>用户列表</caption>
   <tr><th>ID</th><th>用户名</th><th>性别</th><th>手机</th><th>电子邮箱</th><th>地址</th><tr>
    <!--通过Struts2的迭代标签，遍历userList，输出所有用户信息-->
    <s:iterator value="userList" var="user">
   <tr>
   <td>${user.id }</td>
   <td>${user.username }</td>
   <td>${user.sex}</td>
   <td>${user.mobile}</td>
   <td>${user.email}</td>
   <td>${user.address}</td>
   </tr>
    </s:iterator>   
   </table>  
  </body>
</html>
