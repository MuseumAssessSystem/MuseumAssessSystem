<%--
  Created by IntelliJ IDEA.
  User: yve
--%>
<!-- 博物馆管理 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <c:import url="/Views/Common/Import.jsp"/>

    <link rel="stylesheet" type="text/css" href="/Content/Styles/quantitative/museum.css">

    <script type="text/javascript" src="/Content/Scripts/quantitative/museum.js"></script>

</head>
<body>
<div class="page-wrapper" id="museum">
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
            <div class="container museum-manage">

                <h1>博物馆管理</h1>

                <div class="op-btns">
                    <div class="search" id="search-by-name">
                        <form action="MuseumAction_getMuseumByName" method="post">
                            <input type="text" name="mname" placeholder="按博物馆名称搜索..." >
                            <button type="submit"></button>
                        </form>
                    </div>
                    <div class="op-btn add-museum">
                        <a href="#" class="museum-add">添加博物馆</a>
                    </div>
                    <div class="op-btn year-museum">
                        <a href="#search-by-year">各年份参评单位</a>

                    </div>
                </div>
                <div class="table museum-name-table">
                    <ul class="table-head">
                        <li>序号</li>
                        <li>博物馆名称</li>
                        <li>博物馆类型</li>
                        <li>博物馆级别</li>
                        <li>评审年份</li>
                        <li>操作</li>
                    </ul>
                    <div class="table-body">
                        <s:if test="#museumList.size()!=0">
                            <s:iterator value="#museumList" var="museum" status="index">
                                <ul class="body-item">
                                    <li><s:property value="%{#index.getIndex()+1}"/></li>
                                    <li><s:property value="#museum.mname" /></li>
                                    <li><s:property value="#museum.mtype"/> </li>
                                    <li><s:property value="#museum.mclass"/></li>
                                    <li><s:property value="#museum.year"/></li>
                                    <li>
                                        <a href="javascript:void(0)" class="museum-details">详细信息</a>
                                        <a href="javascript:void(0)" class="museum-alt">修改</a>
                                        <a href="MusemAction_deleteMuseum.action?mid=${museum.mid}" class="museum-delete delete">删除</a>
                                    </li>
                                </ul>
                            </s:iterator>
                            <s:else>没有查询到博物馆...</s:else>
                        </s:if>
                    </div>
                </div>

                <div id="museumDetails" class="pop-up" >
                    <h2>博物馆详情</h2>
                    <div class="table">
                        <table>
                            <tr>
                                <td>博物馆名称：</td>
                                <td>博物馆1</td>
                            </tr>
                            <tr>
                                <td>博物馆类型：</td>
                                <td>自然、科技与专题类</td>
                            </tr>
                            <tr>
                                <td>博物馆级别：</td>
                                <td>省级及省级以上</td>
                            </tr>
                            <tr>
                                <td>评审年份：</td>
                                <td>2007，2008，2009，2010，2011，2012，2013</td>
                            </tr>
                            <tr>
                                <td>详细资料：</td>
                                <td>中央部门</td>
                            </tr>
                        </table>
                    </div>
                    <button class="close">返回</button>
                </div>
                <div id="museumAlt" class="pop-up">
                    <h2>博物馆详情</h2>
                    <div class="table">
                        <table>
                            <tr>
                                <td>博物馆名称：</td>
                                <td>
                                    <form>
                                        <input type="text" name="museumname">
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>博物馆类型：</td>
                                <td>
                                    <form action="" method="post">
                                        <select name="levels">
                                            <option value="">历史文化与综合类</option>
                                            <option value="">自然科技与专题类</option>
                                            <option value="">纪念类</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>博物馆级别：</td>
                                <td>
                                    <form action="" method="post">
                                        <select name="levels">
                                            <option value="above">省管及省级以上</option>
                                            <option value="others">其他</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>评审年份：</td>
                                <td>
                                    <form action="" method="post">
                                        <input type="checkbox" name="years" value="2007">2007
                                        <input type="checkbox" name="years" value="2008">2008
                                        <input type="checkbox" name="years" value="2009">2009
                                        <input type="checkbox" name="years" value="2010">2010
                                        <input type="checkbox" name="years" value="2011">2011
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>详细资料：<br>(不得少于250字)</td>
                                <td><textarea rows="10" cols="30">不得少于250字</textarea></td>
                            </tr>
                        </table>
                    </div>
                    <button>提交</button>
                    <button class="close">取消</button>
                </div>
                <div id="museumAdd" class="pop-up">
                    <h2>博物馆详情</h2>
                    <div class="table">
                        <table>
                            <tr>
                                <td>博物馆名称：</td>
                                <td>
                                    <form method="post">
                                        <input type="text" name="museumname">
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>博物馆类型：</td>
                                <td>
                                    <form action="" method="post">
                                        <select name="levels">
                                            <option value="">历史文化与综合类</option>
                                            <option value="">自然科技与专题类</option>
                                            <option value="">纪念类</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>博物馆级别：</td>
                                <td>
                                    <form action="" method="post">
                                        <select name="levels">
                                            <option value="above">省管及省级以上</option>
                                            <option value="others">其他</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>评审年份：</td>
                                <td>
                                    <form action="" method="post">
                                        <input type="checkbox" name="years" value="2007">2007
                                        <input type="checkbox" name="years" value="2008">2008
                                        <input type="checkbox" name="years" value="2009">2009
                                        <input type="checkbox" name="years" value="2010">2010
                                        <input type="checkbox" name="years" value="2011">2011
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>详细资料：<br>(不得少于250字)</td>
                                <td><textarea rows="10" cols="30">不得少于250字</textarea></td>
                            </tr>
                        </table>
                    </div>
                    <button>提交</button>
                    <button class="close">取消</button>
                </div>

            </div>
            <div class="container year-museum">
                <h1>各年份参评单位</h1>
                <div class="search" id="search-by-year">
                    <form action="MuseumAction_getMuseumByYear" method="post">
                        <select name="years" >
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
                <div class="table museum-year-table">
                    <ul class="table-head">
                        <li>序号</li>
                        <li>博物馆名称</li>
                        <li>博物馆类型</li>
                        <li>博物馆级别</li>

                    </ul>
                    <div class="table-body">
                        <s:if test="#museum.size()!=0">
                            <s:iterator value="#museum" var="museumlist" status="index">
                                <ul class="body-item">
                                    <li><s:property value="%{#index.getIndex()+1}" /></li>
                                    <li><s:property value="#museumlist.mname"/> </li>
                                    <li><s:property value="#museumlist.mtype"/></li>
                                    <li><s:property value="#museumlist.mclass"/> </li>
                                </ul>
                            </s:iterator>
                            <s:else>没有查询到博物馆...</s:else>
                        </s:if>
                    </div>
                </div>
            </div>
            <div class="mask"></div>
        </div>
    </div>
</div>
</body>
</html>