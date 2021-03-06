<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="/Views/Common/Import.jsp"/>
    <link rel="stylesheet" type="text/css" href="/Content/Styles/qualitative/sheet.css">
    <script type="text/javascript" src="/Content/Scripts/qualitative/sheet.js"></script>
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

                <div class="mask"></div>

                <h1>打分表管理</h1>

                <div class="op-btns">
                    <div class="search" id="search_by_name">
                        <form action="SheetAction_sheetSearch">
                            <input type="text" name="expertName" placeholder="请输入专家姓名..." class="input_name">
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
                    <div class="op-btn upload_option" id="upload_option">
                        <a href="#">上传专家定性评估意见书</a>
                    </div>
                </div>

                <div class="table upload_option_list">
                    <ul class="table-head">
                        <li>序号</li>
                        <li>专家姓名</li>
                        <li>上传打分表文件</li>
                        <li>上传时间</li>
                        <li>操作</li>
                    </ul>
                    <div class="table-body">
                        <s:if test="#session.sheets.size()!=0">
                            <s:iterator value="#session.sheets" var="sheet" status="index">
                        <ul class="body-item">
                            <li><s:property value="%{#index.getIndex()+1}"/></li>
                            <li><c:out value="${sheet['ename']}"/></li>
                            <li><c:out value="${sheet['sheetName']}"></c:out></li>
                            <li><c:out value="${sheet['upTime']}"/></li>
                            <li>
                                <a href="DownlodaAction_download.action?filename=${sheet['sheetPath']}">下载打分表</a>
                                <a href="javascript:void(0)" class="sheet_detail">详尽信息</a>
                                <a href="DeleteFileAction_deleteFile.action?filePath=${sheet['sheetPath']}" class="sheet_delete">删除</a>
                            </li>
                        </ul>
                            </s:iterator>
                        </s:if>
                        <s:else>没有打分表文件...</s:else>
                    </div>

                </div>

            </div>
        </div>

    </div>
</div>
</body>
</html>