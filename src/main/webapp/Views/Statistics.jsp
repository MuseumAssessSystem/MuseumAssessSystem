<%--
  Created by IntelliJ IDEA.
  User: yve
--%>
<!-- 定量数据 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>博物馆评估管理系统</title>

    <%@include file="/Views/Common/Import.jsp" %>
    <link rel="stylesheet" type="text/css" href="/Content/Styles/quantitative/data.css">
    <script src="/Content/Scripts/quantitative/data.js"></script>
</head>
<body>
<div class="page-wrapper">
    <!-- 导航栏 -->
    <div class="nav-wrap">
        <%@ include file="/Views/Common/Navbar.jsp" %>
    </div>
    <div class="content-wrap">
        <!-- header -->
        <div class="header-wrap">
            <%@ include file="/Views/Common/Header.jsp" %>
        </div>
        <!-- 内容区 -->
        <div class="container-wrap">
            <div class="second-nav" id="quantitative-rank">
                <ul>
                    <li class="tab" id="overall-tab"><a href="javascript:void(0);">总体排名</a></li>
                    <li class="tab" id="first-tab"><a href="javascript:void(0);">一级排名</a></li>
                    <li class="tab" id="second-tab"><a href="javascript:void(0);">二级排名</a></li>
                </ul>
            </div>
            <div id="tab-container">
                <div class="container" id="overall">
                </div>
                <div class="container hide" id="first">
                </div>
                <div class="container hide" id="second">
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>