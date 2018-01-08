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
                        <form>
                            <input type="text" placeholder="请输入专家姓名..." class="input_name">
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
                            <s:iterator value="#session.sheets" var="sheet">
                        <ul class="body-item">
                            <li>1</li>
                            <li><c:out value="${sheet['ename']}"/></li>
                            <li><c:out value="${sheet['sheetName']}"></c:out></li>
                            <li>2007</li>
                            <li>
                                <a href="DownlodaAction_download.action?filename=${sheet['sheetPath']}">下载打分表</a>
                                <a href="javascript:void(0)"class="sheet_detail">详尽信息</a>
                                <a href="javascript:void(0)"class="sheet_delete">删除</a>
                            </li>
                        </ul>
                            </s:iterator>
                        </s:if>
                        <s:else>没有打分表文件...</s:else>
                    </div>

                </div>

                <!-- 上传打分表-->
                <div class="pop-up" id="upload_sheet">
                    <h2>上传打分表</h2>
                    <div class="table">
                        <table>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    评审年份：
                                </td>
                                <td>
                                    <form>
                                        <select name="year" class="year">
                                            <option value="2007" selected>2007</option>
                                            <option value="2008">2008</option>
                                            <option value="2009">2009</option>
                                            <option value="2010">2010</option>
                                            <option value="2011">2011</option>
                                            <option value="2012">2012</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    用户名称：
                                </td>
                                <td>
                                    <form action="">
                                        <select class="user_name" name="user_name">
                                            <option value="">专家1</option>
                                            <option value="">专家1</option>
                                            <option value="">专家1</option>
                                            <option value="">专家1</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    定性评估意见书文件：
                                </td>
                                <td>
                                    <form>
                                        <input type="file" name="option_file" class="option_file" id="option_file" multiple="multiple">
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="button_style">
                        <button>提交</button>
                        <button class="close">取消</button>
                    </div>
                </div>

                <!-- 详尽信息-->
                <div class="pop-up" id="detail_file">
                    <h2>文件详情</h2>
                    <div>
                        打分表文件
                    </div>
                    <div class="button_style">
                        <button>提交</button>
                        <button class="close">取消</button>
                    </div>
                </div>

            </div>

            <!-- 未提交定性评估意见书专家名单-->
            <div class="container">

                <div class="mask"></div>

                <h1>未提交定性评估意见书专家名单</h1>

                <div class="op-btns">
                    <div class="search" id="search_by_year">
                        <form>
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
                        <ul class="body-item">
                            <li>1</li>
                            <li>专家1</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>