<!-- 首页 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>博物馆评估管理系统</title>
    <link rel="stylesheet" href="/Content/Styles/common/reset.css">
    <
    <link rel="stylesheet" href="/Content/Library/supersized.css">
    <link rel="stylesheet" href="/Content/Styles/index.css">

    <script src="/Content/Library/jquery.min.js"></script>
    <script src="/Content/Library/supersized.3.2.7.min.js"></script>
    <script src="/Content/Scripts/index.js"></script>
</head>
<body>
<div class="page-container">
    <h1>Login</h1>
    <form action="UserAction_login" method="post">
        <input type="text" name="username" class="username" placeholder="Username">
        <input type="password" name="password" class="password" placeholder="Password">
        <button type="submit">Login</button>
        <div class="error"></div>
    </form>
</body>
</html>