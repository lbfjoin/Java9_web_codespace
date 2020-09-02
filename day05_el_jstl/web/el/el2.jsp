<%--
  Created by IntelliJ IDEA.
  User: lbf
  Date: 2020/8/31
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //在域中存储对象
    session.setAttribute("name","李四");
    request.setAttribute("name","张三");
    session.setAttribute("age","23");
    request.setAttribute("str","");
%>
<h3>el获取值</h3>
${requestScope.name}
${sessionScope.name}
${sessionScope.age}
${name}   <%--张三  因为session域范围比request大，如果名字冲突，取就近原则--%>
</body>
</html>
