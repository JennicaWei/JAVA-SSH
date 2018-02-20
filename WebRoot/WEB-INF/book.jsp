<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h4>Books page</h4>


    <a href="book.jsp?book=JavaWeb">JavaWeb</a><br>
    <a href="book.jsp?book=Java">Java</a><br>
    <a href="book.jsp?book=Oracle">Oracle</a><br>
    <a href="book.jsp?book=Ajax">Ajax</a><br>
    <a href="book.jsp?book=JavaScript">JavaScript</a><br>
    <a href="book.jsp?book=Andriod">Andriod</a><br>
    <a href="book.jsp?book=Jbmp">Jbmp</a><br>
    <a href="book.jsp?book=Struts">Struts</a><br>
    <a href="book.jsp?book=Hibernate">Hibernate</a><br>
    <a href="book.jsp?book=Spring">Spring</a><br>
    <br>
    <%
        //显示最近浏览的5本书
        //获取所有的cookie
        Cookie []cookies = request.getCookies();

        //从中筛选出book 的cookie 若果cookie为CHANCE_BOOK开头 则符合条件
        //显示出cookieValue
        if(cookies != null && cookies.length > 0){
            for(Cookie c :cookies){
                String cookieName = c.getName();
                if(cookieName.startsWith("CHANCE_BOOK")){
                    out.println(c.getValue());
                    out.print("&nbsp;&nbsp;&nbsp;&nbsp;");
                }
            }
        }
    %>

</body>
</html>