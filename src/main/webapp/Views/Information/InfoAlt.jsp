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

    <link rel="stylesheet" type="text/css" href="/Content/Styles/Information/infoalt.css">

    <script type="text/javascript" src="/Content/Scripts/Information/infoalt.js"></script>
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
                                <td>
                                    <span class="red">*</span>
                                    用户名称：
                                </td>
                                <td>
                                    <form>
                                        <input type="text" name="update_user" class="input" id="update_user">
                                        <span class="word_note">不超过10个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    密码：
                                </td>
                                <td>
                                    <form>
                                        <input type="password" name="input_password" class="input" id="input_password">
                                        <span class="word_note">6-10个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    请在次输入密码：
                                </td>
                                <td>
                                    <form>
                                        <input type="password" name="update_password_again" class="input" id="update_password_again">
                                        <span class="word_note">6-10个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>email</td>
                                <td>
                                    <form>
                                        <input type="email" name="update_email" class="input" id="update_email">
                                        <span class="word_note">最多60个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>手机号码</td>
                                <td>
                                    <form>
                                        <input type="telephone" name="update_tel" class="input" id="update_tel">
                                        <span class="word_note">11为手机号码</span>
                                    </form>
                                </td>
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