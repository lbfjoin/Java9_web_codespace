<%--
  Created by IntelliJ IDEA.
  User: lbf
  Date: 2020/8/29
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<%= response.getWriter().write(request.getSession().getAttribute("user").toString())%>--%>
<h1><%=  request.getSession().getAttribute("user")%> ,欢迎您</h1>

</body>
</html>
