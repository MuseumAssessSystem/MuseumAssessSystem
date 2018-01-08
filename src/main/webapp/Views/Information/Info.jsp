<%--
  Created by IntelliJ IDEA.
  User: Satan
  Date: 2018/1/5
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="/Views/Common/Import.jsp"/>

    <link rel="stylesheet" type="text/css" href="/Content/Styles/Information/info.css">

    <script type="text/javascript" src="/Content/Scripts/Information/info.js"></script>
</head>
<body>
<div class="page-wrapper">
    <!-- 导航栏 -->
    <div class="nav-wrap">
        <%@ include file="/Views/Common/Navbar.jsp"%>
    </div>
    <div class="content-wrap">
        <!-- header -->
        <div class="header-wrap">
            <%@ include file="/Views/Common/Header.jsp"%>
        </div>

        <!-- 内容区 -->
        <div class="container-wrap">
            <div class="container">

                <div class="user" id="user_list">
                    <h1>用户信息</h1>
                    <div class="table" id="user_table">
                        <table>
                            <tr>
                                <td>用户名称:</td>
                                <td>expert</td>
                            </tr>
                            <tr>
                                <td>email:</td>
                                <td>hjadsklhfa@163.com</td>
                            </tr>
                            <tr>
                                <td>手机号码:</td>
                                <td>18122346985</td>
                            </tr>
                        </table>
                    </div>

                </div>

            </div>
        </div>

    </div>
</div>
</body>
</html>
