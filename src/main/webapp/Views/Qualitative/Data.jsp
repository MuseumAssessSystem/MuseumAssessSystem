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

    <link rel="stylesheet" type="text/css" href="/Content/Styles/qualitative/data.css">

    <script type="text/javascript" src="/Content/Scripts/qualitative/data.js"></script>
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
            <%--总排名--%>
            <div class="second-nav" id="quantitative-rank">
                <ul>
                    <li class="tab" id="overall-tab"><a href="javascript:void(0);">总体排名</a></li>
                    <li class="tab" id="first-tab"><a href="javascript:void(0);">一级排名</a></li>
                    <li class="tab" id="second-tab"><a href="javascript:void(0);">二级排名</a></li>
                </ul>
            </div>
            <div id="tab-container">
                <div class="container" id="overall">
                    <div class="table-tabs">
                        <ul>
                            <li class="table-tab" id="oall-tab"><a href="javascript:void(0);">总体排名</a></li>
                            <li class="table-tab" id="ofirst-tab"><a href="javascript:void(0);">一级排名</a></li>
                            <li class="table-tab" id="osecond-tab"><a href="javascript:void(0);">二级排名</a></li>
                        </ul>
                    </div>
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
                            <div class="table dx_all_rank">
                                <ul class="table-head">
                                    <li class="dx_all_index">序号</li>
                                    <li class="dx_all_museum">博物馆名称</li>
                                    <li class="dx_all_year">参评年份</li>
                                    <li class="dx_all_type">类型</li>
                                    <li class="dx_all_level">级别</li>
                                    <li class="dx_all_rank">定性排名</li>
                                    <li class="dx_all_type_rank">定性类型排名</li>
                                    <li class="dx_all_level_rank">定性级别排名</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2008</li>
                                        <li>纪念类</li>
                                        <li>其他</li>
                                        <li>2</li>
                                        <li>1</li>
                                        <li>2</li>
                                    </ul>
                                    <ul class="body-item">
                                        <li>2</li>
                                        <li>博物馆2</li>
                                        <li>2008</li>
                                        <li>遗址类</li>
                                        <li>省级及省级以上</li>
                                        <li>3</li>
                                        <li>1</li>
                                        <li>1</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="ofirst" class="hide">
                            <div class="table dx_one_rank">
                                <ul class="table-head">
                                    <li class="dx_one_index">序号</li>
                                    <li class="dx_one_museum">博物馆名称</li>
                                    <li class="dx_one_year">参评年份</li>
                                    <li class="dx_one_goods">藏品管理</li>
                                    <li class="dx_one_science">科学研究</li>
                                    <li class="dx_one_display">陈列展览与社会教育</li>
                                    <li class="dx_one_serve">公共关系与服务</li>
                                    <li class="dx_one_develop">博物馆管理与发展建设</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2008</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>2</li>
                                    </ul>
                                    <ul class="body-item">
                                        <li>2</li>
                                        <li>博物馆2</li>
                                        <li>2008</li>
                                        <li>2</li>
                                        <li>1</li>
                                        <li>5</li>
                                        <li>2</li>
                                        <li>3</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="osecond" class="hide">
                            <div class="table dx_two_rank">
                                <ul class="table-head">
                                    <li class="dx_two_index">序号</li>
                                    <li class="dx_two_museum">博物馆名称</li>
                                    <li class="dx_two_year">参评<br>年份</li>
                                    <li class="dx_two_goods">藏品<br>搜集</li>
                                    <li class="dx_two_science">藏品<br>保护</li>
                                    <li class="dx_two_display">藏品<br>保管</li>
                                    <li class="dx_two_develop">学术<br>活动</li>
                                    <li class="">代表性研究成果</li>
                                    <li class="">基本<br>陈列</li>
                                    <li class="">代表性原创临时展</li>
                                    <li class="">博物馆讲解</li>
                                    <li class="">教育<br>项目</li>
                                    <li class="">公共<br>关系</li>
                                    <li class="">公众<br>服务</li>
                                    <li class="">博物馆网站</li>
                                    <li class="">发展<br>规划</li>
                                    <li class="">制度<br>建设</li>
                                    <li class="">安全<br>管理</li>
                                    <li class="">人才<br>培养</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博1</li>
                                        <li>2008</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="container hide" id="first">
                    <div class="table-tabs">
                        <ul>
                            <li class="table-tab" id="ftype-tab"><a href="javascript:void(0);">类型排名</a></li>
                            <li class="table-tab" id="flevel-tab"><a href="javascript:void(0);">级别排名</a></li>
                        </ul>
                    </div>

                    <div class="table-tab-container">
                        <div class="op-btns">
                            <div class="search" id="search_all">
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
                        <div id="ftype">
                            <div class="table dx1_one_rank">
                                <ul class="table-head">
                                    <li class="dx_one_index">序号</li>
                                    <li class="dx_one_museum">博物馆名称</li>
                                    <li class="dx_one_year">参评年份</li>
                                    <li class="dx_one_types">类型</li>
                                    <li class="dx_one_goods">藏品管理</li>
                                    <li class="dx_one_science">科学研究</li>
                                    <li class="dx_one_display">陈列展览与社会教育</li>
                                    <li class="dx_one_serve">公共关系与服务</li>
                                    <li class="dx_one_develop">博物馆管理与发展建设</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2008</li>
                                        <li>纪念类</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>2</li>
                                    </ul>
                                    <ul class="body-item">
                                        <li>2</li>
                                        <li>博物馆2</li>
                                        <li>2008</li>
                                        <li>纪念类</li>
                                        <li>2</li>
                                        <li>1</li>
                                        <li>5</li>
                                        <li>2</li>
                                        <li>3</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="flevel" class="hide">
                            <div class="table dx1_one_rank">
                                <ul class="table-head">
                                    <li class="dx_one_index">序号</li>
                                    <li class="dx_one_museum">博物馆名称</li>
                                    <li class="dx_one_year">参评年份</li>
                                    <li class="dx_one_level">级别</li>
                                    <li class="dx_one_goods">藏品管理</li>
                                    <li class="dx_one_science">科学研究</li>
                                    <li class="dx_one_display">陈列展览与社会教育</li>
                                    <li class="dx_one_serve">公共关系与服务</li>
                                    <li class="dx_one_develop">博物馆管理与发展建设</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2008</li>
                                        <li>其他</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>2</li>
                                    </ul>
                                    <ul class="body-item">
                                        <li>2</li>
                                        <li>博物馆2</li>
                                        <li>2008</li>
                                        <li>省级及省级以上</li>
                                        <li>2</li>
                                        <li>1</li>
                                        <li>5</li>
                                        <li>2</li>
                                        <li>3</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>


                <div class="container hide" id="second">
                    <div class="table-tabs">
                        <ul>
                            <li class="table-tab" id="stype-tab"><a href="javascript:void(0);">类型排名</a></li>
                            <li class="table-tab" id="slevel-tab"><a href="javascript:void(0);">级别排名</a></li>
                        </ul>
                    </div>

                    <div class="table-tab-container">
                        <div class="op-btns">
                            <div class="search" id="search_two_all">
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

                        <div id="stype">
                            <div class="table dx2_two_rank">
                                <ul class="table-head">
                                    <li class="dx_two_index">序号</li>
                                    <li class="dx_two_museum">博物馆名称</li>
                                    <li class="dx_two_year">参评<br>年份</li>
                                    <li class="dx_two_type">类型</li>
                                    <li class="dx_two_goods">藏品<br>搜集</li>
                                    <li class="dx_two_science">藏品<br>保护</li>
                                    <li class="dx_two_display">藏品<br>保管</li>
                                    <li class="dx_two_develop">学术<br>活动</li>
                                    <li class="">代表性研究成果</li>
                                    <li class="">基本<br>陈列</li>
                                    <li class="">代表性原创临时展</li>
                                    <li class="">博物馆讲解</li>
                                    <li class="">教育<br>项目</li>
                                    <li class="">公共<br>关系</li>
                                    <li class="">公众<br>服务</li>
                                    <li class="">博物馆网站</li>
                                    <li class="">发展<br>规划</li>
                                    <li class="">制度<br>建设</li>
                                    <li class="">安全<br>管理</li>
                                    <li class="">人才<br>培养</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2008</li>
                                        <li>纪念类</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                        <div id="slevel" class="hide">
                            <div class="table dx2_two_rank">
                                <ul class="table-head">
                                    <li class="dx_two_index">序号</li>
                                    <li class="dx_two_museum">博物馆名称</li>
                                    <li class="dx_two_year">参评<br>年份</li>
                                    <li class="dx_two_level">级别</li>
                                    <li class="dx_two_goods">藏品<br>搜集</li>
                                    <li class="dx_two_science">藏品<br>保护</li>
                                    <li class="dx_two_display">藏品<br>保管</li>
                                    <li class="dx_two_develop">学术<br>活动</li>
                                    <li class="">代表性研究成果</li>
                                    <li class="">基本<br>陈列</li>
                                    <li class="">代表性原创临时展</li>
                                    <li class="">博物馆讲解</li>
                                    <li class="">教育<br>项目</li>
                                    <li class="">公共<br>关系</li>
                                    <li class="">公众<br>服务</li>
                                    <li class="">博物馆网站</li>
                                    <li class="">发展<br>规划</li>
                                    <li class="">制度<br>建设</li>
                                    <li class="">安全<br>管理</li>
                                    <li class="">人才<br>培养</li>
                                </ul>
                                <div class="table-body">
                                    <ul class="body-item">
                                        <li>1</li>
                                        <li>博物馆1</li>
                                        <li>2008</li>
                                        <li>其他</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>1</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                        <li>2</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="container">
                <h1>定性数据计算</h1>
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
                            <button type="submit" class="dx_btn"></button>
                        </form>
                    </div>
                </div>
                <%--<div class="dx_calculate">--%>
                    <%--定性得分：<span>90</span>--%>
                <%--</div>--%>
            </div>
        </div>
    </div>
</div>
</body>
</html>
