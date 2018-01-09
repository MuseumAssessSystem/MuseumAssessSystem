<%--
  Created by IntelliJ IDEA.
  User: yve
--%>
<!-- 申报书管理 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <c:import url="/Views/Common/Import.jsp"/>

    <link rel="stylesheet" type="text/css" href="/Content/Styles/quantitative/application.css">

    <script type="text/javascript" src="/Content/Scripts/quantitative/application.js"></script>

</head>
<body>
<div class="page-wrapper" id="application">
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
            <div class="container">
                <h1>申报书管理</h1>

                <div class="op-btns">
                    <div class="search" id="search-by-name">
                        <form action="WordAction_dirSearch">
                            <input type="text" name="museumName" placeholder="请输入博物馆名称...">
                            <select name="year" class="year">
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
                    <div class="op-btn upload-application">
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
                        <s:if test="#session.words.size()!=0">
                        <s:iterator value="#session.words" var="word">
                        <ul class="body-item">
                            <li>1</li>
                            <li><c:out value="${word['mname']}"/></li>
                            <li><c:out value="${word['upTime']}"/></li>
                            <li><c:out value="${word['year']}"/></li>
                            <li>
                                <a href="DownZipAction_downloadzip.action?filename=${word['dirName']}&filePath=${word['dirPath']}">下载申报书</a>
                                <a href="javascript:void(0)" class="file-manage">文件管理</a>
                                <a href="DeleteFileAction_deleteFile.action?filePath=${word['dirPath']}" class="delete">删除申报书</a>
                            </li>
                        </ul>
                        </s:iterator>
                        </s:if>
                        <s:else>没有申报书....</s:else>
                    </div>
                </div>
                <div class="pop-up" id="upload">
                    <h2>上传申报书</h2>
                    <form action="" enctype="multipart/form-data" method="post">
                        <div class="table upload-table">
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
                                            <input type="file" name="application" accept="application/msword,aplication/zip,application/x-rar-compressed">
                                    </td>
                                </tr>

                            </table>
                        </div>
                        <button type="submit">提交</button>
                        <button class="close">取消</button>
                    </form>
                </div>
                <div class="pop-up" id="file">
                    <h2>文件管理</h2>
                    <div class="upload">
                        <button class="add-files">添加文件</button>
                        <form>
                            <ul class="upload-input">
                                    <li>
                                        <input type="file" name="file0" accept="application/msword,aplication/zip,application/x-rar-compressed">
                                        <button class="delete-input">删除</button>
                                    </li>

                            </ul>
                            <button type="submit">提交</button>
                            <button class="close">返回</button>
                        </form>
                    </div>
                    <div class="file-details">
                        <div class="table file-table">
                            <table>
                                <tr class="head-item">
                                    <td>序号</td>
                                    <td>文件名</td>
                                    <td>操作</td>
                                </tr>
                                <tr class="body-item">
                                    <td>1</td>
                                    <td>博物馆1</td>
                                    <td>
                                        <a href="javascript:void(0)">下载</a>
                                        <a href="javascript:void(0)" class="delete">删除</a>
                                    </td>
                                </tr>
                            </table>
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