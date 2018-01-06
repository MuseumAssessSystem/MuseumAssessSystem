<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10922
  Date: 2018/1/5
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件管理</title>
</head>
<body>
    <h2>申报书管理</h2>
    <button><a href="FileManageAction_filaManage.action">文件管理</a></button>
    <c:forEach items="filesName" var="item">
        <s:property value="item"></s:property> <br/>
    </c:forEach>
</body>
</html>
