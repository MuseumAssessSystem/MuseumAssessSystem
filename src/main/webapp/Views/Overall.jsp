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

    <link rel="stylesheet" type="text/css" href="/Content/Styles/overall.css">

    <script type="text/javascript" src="/Content/Scripts/overall.js"></script>
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
        <div class="container-wrap">
            <%--总排名--%>
            <div class="second-nav" id="quantitative-rank">
                <ul>
                    <li class="tab" id="overall-tab"><a href="javascript:void(0);">总分排名</a></li>
                    <li class="tab" id="first-tab"><a href="javascript:void(0);">总分类型排名</a></li>
                    <li class="tab" id="second-tab"><a href="javascript:void(0);">总分地区排名</a></li>
                </ul>
            </div>
                <div id="tab-container">
                    <div class="container" id="overall">
                        <div class="table-tab-container">
                            <div class="op-btns">
                                <div class="search" id="search_dx_all">
                                    <form>
                                        <input type="text" placeholder="请输入图书馆名称...">
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
                            </div>

                            <div id="oall">
                                <div class="table rank_all">
                                    <ul class="table-head">
                                        <li class="dx_two_index">序号</li>
                                        <li class="dx_two_museum">博物馆名称</li>
                                        <li class="dx_two_year">博物馆类型</li>
                                        <li class="dx_two_type">博物馆级别</li>
                                        <li class="dx_two_goods">年份</li>
                                        <li class="dx_two_science">总分排名</li>
                                        <li class="dx_two_display">定性总分排名</li>
                                        <li class="dx_two_develop">定量总分排名</li>
                                    </ul>
                                    <div class="table-body">
                                        <ul class="body-item">
                                            <li>1</li>
                                            <li>博物馆1</li>
                                            <li>纪念类</li>
                                            <li>其他</li>
                                            <li>2008</li>
                                            <li>2</li>
                                            <li>1</li>
                                            <li>2</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="container hide" id="first">
                        <div class="table-tab-container">
                            <div class="op-btns">
                                <div class="search" id="search_dx_type">
                                    <form>
                                        <input type="text" placeholder="请输入图书馆名称...">
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
                            </div>

                            <div id="otype">
                                <div class="table rank_type">
                                    <ul class="table-head">
                                        <li class="dx_two_index">序号</li>
                                        <li class="dx_two_museum">博物馆名称</li>
                                        <li class="dx_two_year">博物馆类型</li>
                                        <li class="dx_two_type">博物馆级别</li>
                                        <li class="dx_two_goods">年份</li>
                                        <li class="dx_two_science">总分类型排名</li>
                                    </ul>
                                    <div class="table-body">
                                        <ul class="body-item">
                                            <li>1</li>
                                            <li>博物馆1</li>
                                            <li>纪念类</li>
                                            <li>其他</li>
                                            <li>2008</li>
                                            <li>2</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="container hide" id="second">
                        <div class="table-tab-container">
                            <div class="op-btns">
                                <div class="search" id="search_dx_area">
                                    <form>
                                        <input type="text" placeholder="请输入图书馆名称...">
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
                            </div>

                            <div id="oarea">
                                <div class="table rank_area">
                                    <ul class="table-head">
                                        <li class="dx_two_index">序号</li>
                                        <li class="dx_two_museum">博物馆名称</li>
                                        <li class="dx_two_year">博物馆类型</li>
                                        <li class="dx_two_type">博物馆级别</li>
                                        <li class="dx_two_goods">年份</li>
                                        <li class="dx_two_science">总分地区排名</li>
                                    </ul>
                                    <div class="table-body">
                                        <ul class="body-item">
                                            <li>1</li>
                                            <li>博物馆1</li>
                                            <li>纪念类</li>
                                            <li>其他</li>
                                            <li>2008</li>
                                            <li>2</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            <div class="container">
                <h1>总分数据计算</h1>
                <div class="op-btns" id="op_btns">
                    <div class="search" id="search_all_year">
                        <form method="post">
                            <select name="years">
                                <option value="2007" selected>2007</option>
                                <option value="2008">2008</option>
                                <option value="2009">2009</option>
                                <option value="2010">2010</option>
                                <option value="2011">2011</option>
                                <option value="2012">2012</option>
                            </select>
                            <button type="submit" class="all_btn"></button>
                        </form>
                    </div>
                </div>
                <%--<div class="all_calculate">--%>
                    <%--定性得分：<span>90</span>--%>
                <%--</div>--%>
            </div>
        </div>
    </div>
</div>
</body>
</html>
