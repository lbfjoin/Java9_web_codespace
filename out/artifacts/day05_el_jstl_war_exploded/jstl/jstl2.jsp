<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose标签</title>
</head>
<body>
<%
    request.setAttribute("number",5);
%>
<d:choose>
    <d:when test="${number == 1}">星期一</d:when>
    <d:when test="${number == 2}">星期二</d:when>
    <d:when test="${number == 3}">星期三</d:when>
    <d:when test="${number == 4}">星期四</d:when>
    <d:when test="${number == 5}">星期五</d:when>
    <d:when test="${number == 6}">星期六</d:when>
    <d:when test="${number == 7}">星期日</d:when>
    <d:otherwise >过年</d:otherwise>
</d:choose>
</body>
</html>
