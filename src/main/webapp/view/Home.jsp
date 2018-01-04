<%--
  Created by IntelliJ IDEA.
  User: yve
--%>
<!-- 首页 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>博物馆评估管理系统</title>

	<%@include file="./Common/Import.jsp"%>
    <link rel="stylesheet" type="text/css" href="../Content/Styles/home.css">
</head>
<body>
<div class="page-wrapper">
	<!-- 导航栏 -->
	<div class="nav-wrap">
        <%@ include file="./Common/Navbar.jsp"%>
	</div>
	<div class="content-wrap">
		<!-- header -->
        <div class="header-wrap">
            <%@ include file="./Common/Header.jsp"%>
        </div>
		<!-- 内容区 -->
		<div class="container-wrap">
			<div class="container"></div>
		</div>
	</div>
</div>
</body>
</html>