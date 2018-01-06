<!-- 申报书管理 -->
<%--
  Created by IntelliJ IDEA.
  User: yve
--%>
<!-- 博物馆管理 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <c:import url="../Common/Import.jsp"/>

    <link rel="stylesheet" type="text/css" href="/Content/Styles/quantitative/application.css">

    <script type="text/javascript" src="/Content/Scripts/quantitative/application.js"></script>

</head>
<body>
<div class="page-wrapper" id="application">
    <!-- 导航栏 -->
    <div class="nav-wrap">
        <%@ include file="../Common/Navbar.jsp" %>
    </div>
    <div class="content-wrap">
        <!-- header -->
        <div class="header-wrap">
            <%@ include file="../Common/Header.jsp" %>
        </div>
        <!-- 内容区 -->
        <div class="container-wrap">
            <div class="container">
                <h1>申报书管理</h1>
                <div class="search" id="search-by-name">
                    <form>
                        <input type="text" placeholder="按博物馆名称搜索...">
                        <select name="years">
                            <option value="2007" selected>2007</option>
                            <option value="2008">2008</option>
                            <option value="2009">2009</option>
                            <option value="2010">2010</option>
                            <option value="2011">2011</option>
                            <option value="2012">2012</option>
                        </select>
                        <button type="submit"></button>
                    </form>
                </div>
                <div class="museum-btns">
                    <div class="museum-btn upload-application">
                        <a href="#">上传申报书</a>
                    </div>
                </div>
                <div class="table application-table">
                    <ul class="table-head">
                        <li>序号</li>
                        <li>博物馆名称</li>
                        <li>上传时间</li>
                        <li>参评年份</li>
                        <li>操作</li>
                    </ul>
                    <div class="table-body">
                        <ul class="body-item">
                            <li>1</li>
                            <li>博物馆1</li>
                            <li></li>
                            <li>2007</li>
                            <li>
                                <a href="javascript:void(0)">下载申报书</a>
                                <a href="javascript:void(0)" class="file-manage" onclick="$('#file,.mask').show();">文件管理</a>
                                <a href="javascript:void(0)">删除申报书</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="pop-up" id="upload">
                    <form action="" enctype="multipart/form-data" method="post">
                        <div class="table">
                            <table>
                                <tr>
                                    <td>请选择博物馆及年份：</td>
                                    <td>
                                        <select name="museums">
                                            <option value="博物馆1">博物馆1</option>
                                            <option value="博物馆2">博物馆2</option>
                                            <option value="博物馆3">博物馆3</option>
                                        </select>
                                        <select name="years">
                                            <option value="2007" selected>2007</option>
                                            <option value="2008">2008</option>
                                            <option value="2009">2009</option>
                                            <option value="2010">2010</option>
                                            <option value="2011">2011</option>
                                            <option value="2012">2012</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>上传申报书：</td>
                                    <td>
                                        <input type="file" name="application"><br/>
                                    </td>
                                </tr>

                            </table>
                        </div>
                        <input type="submit" value="提交">
                        <button class="close">取消</button>
                    </form>
                </div>
                <div class="pop-up" id="file">
                    <div class="upload">
                        <button>添加文件</button>
                        <form action="UploadFileAction_upload" enctype="multipart/form-data" method="post">
                            <input type="file" name="dxWord"><br/>

                            <input type="submit" value="提交">
                            <button class="close">返回</button>
                        </form>
                    </div>
                    <div class="file-details">
                        <div class="table file-table">
                            <ul class="table-head">
                                <li>序号</li>
                                <li>文件名</li>
                                <li>操作</li>
                            </ul>
                            <div class="table-body">
                                <ul class="body-item">
                                    <li>1</li>
                                    <li>博物馆1</li>
                                    <li>
                                        <a href="javascript:void(0)">下载</a>
                                        <a href="javascript:void(0)">删除</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mask"></div>
        </div>
    </div>
</div>
</body>
</html>