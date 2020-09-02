<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>forEach标签</title>
</head>
<body>
<%--
begin:开始
end : 结束
var ： 临时变量
step : 步长
varStatus: 循环状态对象
index : 容器中元素的索引
count ： 循环次数（从1开始）
items : 容器对象
--%>
 <c:forEach begin="0" end="10" var="i" step="1" varStatus="s">
     ${i}
     <h3>index ${s.index}</h3>
     <h4>count ${s.count}</h4>
 </c:forEach>
<hr>
<%
    List<Object> list = new ArrayList<>();
    list.add("小鲁班");
    list.add("妲己");
    list.add("后羿");
    request.setAttribute("list",list);

%>
<c:forEach items="${list}" var="str" varStatus="s">
    ${s.index} ---- ${s.count} ${str} <br>

</c:forEach>
</body>
</html>
