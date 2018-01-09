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
            <!-- 未提交定性评估意见书专家名单-->
            <div class="container">

                <div class="mask"></div>

                <h1>未提交定性评估意见书专家名单</h1>

                <div class="op-btns">
                    <div class="search" id="search_by_year">
                        <form action="SheetAction_getUnupExpert">
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
                </div>

                <div class="table not_upload">
                    <ul class="table-head">
                        <li>序号</li>
                        <li>专家姓名</li>
                    </ul>
                    <div class="table-body">
                        <s:if test="#session.unUpExpertList.size()!=0">
                            <s:iterator value="#session.unUpExpertList" var="unUpExpert" status="index">
                                <ul class="body-item">
                                    <li><s:property value="%{#index.getIndex()+1}"/></li>
                                    <li><c:out value="${unUpExpert}"/></li>
                                </ul>
                            </s:iterator>
                            <s:else>所有专家均已上传打分表...</s:else>
                        </s:if>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>