<%--
  Created by IntelliJ IDEA.
  User: yve
--%>
<!-- 导航栏 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="nav-wrap">
    <div class="navbar">
        <a href="" class="logo"><img src="museum.png"></a>
        <ul class="main-menu">
            <li>
                <a href="/Views/Home.jsp" class="active link"><span>首页</span></a>
            </li>
            <li class="sub-menu">
                <a href="#" class="link"><span>定量评估</span></a>
                <ul class="sub">
                    <li><a href="MuseumAction_getAllMuseum">博物馆</a></li>
                    <li><a href="WordAction_wordList.action?dir=/dlassess">申报书</a></li>
                    <li><a href="/Views/Quantitative/Data.jsp">定量数据</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="#" class="link"><span>定性评估</span></a>
                <ul class="sub">
                    <li><a href="/Views/Qualitative/Expert.jsp">专家</a></li>
                    <li><a href="SheetAction_sheetList.action?dir=/dxassess">打分表</a></li>
                    <li><a href="SheetAction_getUnupExpert.action?year=2008">未上传申报书</a></li>
                    <li><a href="/Views/Qualitative/Data.jsp">定性数据</a></li>
                </ul>
            </li>
            <li>
                <a href="/Views/Overall.jsp" class="link"><span>总体评估</span></a>
            </li>
            <li>
                <a href="/Views/Statistics.jsp" class="link"><span>数据统计</span></a>
            </li>
            <li>
                <a href="UserAction_getAllUserRole" class="link"><span>用户管理</span></a>
            </li>
        </ul>
    </div>
</div>