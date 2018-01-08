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
                    <li class="tab" id="overall-tab"><a href="javascript:void(0);">定量总排名</a></li>
                    <li class="tab" id="first-tab"><a href="javascript:void(0);">定量一级排名</a></li>
                    <li class="tab" id="second-tab"><a href="javascript:void(0);">定量二级排名</a></li>
                </ul>
            </div>
            <div id="tab-container">
                <div class="container" id="overall">
                    <h1>博物馆定量排名</h1>
                    <div class="table-tabs">
                        <ul>
                            <li class="table-tab" id="oall-tab"><a href="javascript:void(0);">总体排名</a></li>
                            <li class="table-tab" id="ofirst-tab"><a href="javascript:void(0);">一级排名</a></li>
                            <li class="table-tab" id="osecond-tab"><a href="javascript:void(0);">二级排名</a></li>
                        </ul>
                    </div>
                    <div class="table-tab-container">
                        <div id="oall">
                            <div class="table">
                                <ul class="table-head">
                                    <li>序号</li>
                                    <li>博物馆名称</li>
                                    <li>评审年份</li>
                                    <li>类型</li>
                                    <li>级别</li>
                                    <li>定量排名</li>
                                    <li>定量类型排名</li>
                                    <li>定量级别排名</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2007</li>
                                        <li>自然、科技与专题类</li>
                                        <li>省级及省级以上</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="ofirst" class="hide">
                            <div class="table">
                                <ul class="table-head">
                                    <li>序号</li>
                                    <li>博物馆名称</li>
                                    <li>参评年份</li>
                                    <li>藏品排名</li>
                                    <li>科学研究</li>
                                    <li>展览与教育</li>
                                    <li>人才培养</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2007</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="osecond" class="hide">
                            <div class="table">
                                <ul class="table-head">
                                    <li>序号</li>
                                    <li>博物馆名称</li>
                                    <li>参评年份</li>
                                    <li>藏品搜集</li>
                                    <li>藏品修复</li>
                                    <li>承担项目</li>
                                    <li>研究成果</li>
                                    <li>学术会议</li>
                                    <li>展览排名</li>
                                    <li>教育项目</li>
                                    <li>中青年人才引进培养</li>
                                    <li>员工进修与培训</li>

                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2007</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container hide" id="first">
                    <h1>博物馆定量排名</h1>
                    <div class="table-tabs">
                        <ul>
                            <li class="table-tab" id="ftype-tab"><a href="javascript:void(0);">类型排名</a></li>
                            <li class="table-tab" id="flevel-tab"><a href="javascript:void(0);">级别排名</a></li>
                        </ul>
                    </div>
                    <div class="table-tab-container">
                        <div id="ftype">
                            <div class="table">
                                <ul class="table-head">
                                    <li>序号</li>
                                    <li>博物馆名称</li>
                                    <li>参评年份</li>
                                    <li>类型</li>
                                    <li>藏品排名</li>
                                    <li>科学研究</li>
                                    <li>展览与教育</li>
                                    <li>人才培养</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2007</li>
                                        <li>自然、科技与专题类</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="flevel" class="hide">
                            <div class="table">
                                <ul class="table-head">
                                    <li>序号</li>
                                    <li>博物馆名称</li>
                                    <li>参评年份</li>
                                    <li>级别</li>
                                    <li>藏品排名</li>
                                    <li>科学研究</li>
                                    <li>展览与教育</li>
                                    <li>人才培养</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2007</li>
                                        <li>省馆及省级以上</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container hide" id="second">
                    <h1>博物馆定量排名</h1>
                    <div class="table-tabs">
                        <ul>
                            <li class="table-tab" id="stype-tab"><a href="javascript:void(0);">类型排名</a></li>
                            <li class="table-tab" id="slevel-tab"><a href="javascript:void(0);">级别排名</a></li>
                        </ul>
                    </div>
                    <div class="table-tab-container">
                        <div id="stype">
                            <div class="table">
                                <ul class="table-head">
                                    <li>序号</li>
                                    <li>博物馆名称</li>
                                    <li>评审年份</li>
                                    <li>类型</li>
                                    <li>藏品搜集</li>
                                    <li>藏品修复</li>
                                    <li>承担项目</li>
                                    <li>研究成果</li>
                                    <li>学术会议</li>
                                    <li>展览排名</li>
                                    <li>教育项目</li>
                                    <li>中青年人才引进培养</li>
                                    <li>员工进修与培训</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2007</li>
                                        <li>自然、科技与专题类</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="slevel" class="hide">
                            <div class="table">
                                <ul class="table-head">
                                    <li>序号</li>
                                    <li>博物馆名称</li>
                                    <li>评审年份</li>
                                    <li>级别</li>
                                    <li>藏品搜集</li>
                                    <li>藏品修复</li>
                                    <li>承担项目</li>
                                    <li>研究成果</li>
                                    <li>学术会议</li>
                                    <li>展览排名</li>
                                    <li>教育项目</li>
                                    <li>中青年人才引进培养</li>
                                    <li>员工进修与培训</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2007</li>
                                        <li>省级及省级以上</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                        <li>1</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <h1>定量数据计算</h1>
                <div class="op-btns">
                    <div class="search" id="search_by_name">
                        <form method="post">
                            <select name="years">
                                <option value="2007" selected>2007</option>
                                <option value="2008">2008</option>
                                <option value="2009">2009</option>
                                <option value="2010">2010</option>
                                <option value="2011">2011</option>
                                <option value="2012">2012</option>
                            </select>
                            <button class="dl_btn"></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>