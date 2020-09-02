<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%--c:if
   1.属性 test 必须属性，接受的是boolean表达式
     一般test配合el表达式一起使用
     2.没有else部分，想要的话需要再定义一个 <c:if></c:if>
--%>
<c:if test="false">
    <h1>还有一个月就过节了</h1>
</c:if>
<%
    List<Object> list = new ArrayList<>();
    list.add("aaa");
    request.setAttribute("list",list);
    request.setAttribute("number",6);

%>
<c:if test="${not empty requestScope.list}">
    <h2>遍历集合</h2>
</c:if>
<br>
<c:if test="${number % 2 != 0}">
    <h2>${number}为奇数</h2>
</c:if>
<c:if test="${number % 2 == 0}">
    <h2>${number}为偶数</h2>
</c:if>
</body>
</html>
