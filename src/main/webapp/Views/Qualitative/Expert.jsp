<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <c:import url="/Views/Common/Import.jsp"/>

    <link rel="stylesheet" type="text/css" href="/Content/Styles/qualitative/expert.css">

    <script type="text/javascript" src="/Content/Scripts/qualitative/expert.js"></script>

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


        <div class="container-wrap">
            <!-- 内容区 --><!--专家管理-->
            <div class="container expert_manage">

                <h1>专家管理</h1>

                <div class="op-btns">
                    <div class="search" id="search_by_name">
                        <form method="post">
                            <input type="text" placeholder="按专家名称搜索..." >
                            <button type="submit"></button>
                        </form>
                    </div>
                    <div class="op-btn">
                        <a href="#" class="add_expert">添加专家</a>
                    </div>
                </div>

                <div class="table expert_table">
                    <ul class="table-head">
                        <li>序号</li>
                        <li>专家姓名</li>
                        <li>一级指标</li>
                        <li>操作</li>
                    </ul>
                    <div class="table-body">
                        <ul class="body-item">
                            <li>1</li>
                            <li>专家1</li>
                            <li>商品管理</li>
                            <li>
                                <a href="javascript:void(0)" class="expert_details">详细信息</a>
                                <a href="javascript:void(0)" class="expert_alter">修改</a>
                                <a href="javascript:void(0)" class="expert_delete">删除</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <%--添加专家--%>
                <div class="pop-up" id="insert_expert">
                    <h2>添加专家</h2>
                    <div class="table">
                        <table>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    用户名称：
                                </td>
                                <td>
                                    <form>
                                        <input type="text" name="input_user" class="input" id="input_user">
                                        <span class="word_note">不超过10个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    用户类别：
                                </td>
                                <td>
                                    <form action="">
                                        <select name="insert_evaluate" id="insert_evaluate">
                                            <option value="藏品管理">藏品管理</option>
                                            <option value="科学研究">科学研究</option>
                                            <option value="陈列展览与社会教育">陈列展览与社会教育</option>
                                            <option value="公共关系与服务">公共关系与服务</option>
                                            <option value="博物馆管理与发展建设">博物馆管理与发展建设</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>用户简介：</td>
                                <td>
                                    <form action="">
                                        <textarea name="insert_text" id="insert_text" cols="30" rows="10" placeholder="不超过150字"></textarea>
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

                <%--修改专家信息--%>
                <div class="pop-up" id="alter_expert">
                    <h2>修改专家</h2>
                    <div class="table">
                        <table>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    用户名称：
                                </td>
                                <td>
                                    <form>
                                        <input type="text" name="input_user" class="input" id="alter_user">
                                        <span class="word_note">不超过10个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    用户类别：
                                </td>
                                <td>
                                    <form action="">
                                        <select name="alter_evaluate" id="alter_evaluate">
                                            <option value="藏品管理">藏品管理</option>
                                            <option value="科学研究">科学研究</option>
                                            <option value="陈列展览与社会教育">陈列展览与社会教育</option>
                                            <option value="公共关系与服务">公共关系与服务</option>
                                            <option value="博物馆管理与发展建设">博物馆管理与发展建设</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>用户简介：</td>
                                <td>
                                    <form action="">
                                        <textarea name="insert_text" id="alter_text" cols="30" rows="10" placeholder="不超过150字"></textarea>
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

                <%--专家详情--%>
                <div class="pop-up" id="detail_expert">
                    <h2>专家详情</h2>
                    <div class="table">
                        <table>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    用户名称：
                                </td>
                                <td>专家1</td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    用户类别：
                                </td>
                                <td>商品管理</td>
                            </tr>
                            <tr>
                                <td>用户简介：</td>
                                <td>专家简介信息</td>
                            </tr>
                        </table>
                    </div>
                    <div class="button_style">
                        <button>提交</button>
                        <button class="close">取消</button>
                    </div>
                </div>
                <%--遮照--%>
                <div class="mask"></div>
            </div>

            <!-- 内容区 --><!--指定评审专家-->
            <div class="container expert_appoint">

                <h1>指定评审专家</h1>
                <div class="op-btns" id="op_btns">
                    <div class="search" id="search_by_year">
                        <form>
                            <select name="years">
                                <option value="2007" selected>2007</option>
                                <option value="2008">2008</option>
                                <option value="2009">2009</option>
                                <option value="2010">2010</option>
                                <option value="2011">2011</option>
                                <option value="2012">2012</option>
                            </select>
                            <button type="submit" id="btn"></button>
                        </form>
                    </div>
                </div>

                <!--该年度参评专家-->
                <div class="container expert_evaluate">

                    <h1>该年度参评专家</h1>
                    <div class="table evaluate_table">
                        <ul class="table-head">
                            <li>序号</li>
                            <li>专家姓名</li>
                            <li>评审一级指标</li>
                            <li>操作</li>
                        </ul>
                        <div class="table-body">
                            <ul class="body-item">
                                <li>1</li>
                                <li>专家1</li>
                                <li>商品管理</li>
                                <li>
                                    <a href="javascript:void(0)" class="expert_delete">删除</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div>

                <!--该年度备选参评专家-->
                <div class="container expert_not_evaluate">

                    <h1>该年度备选参评专家</h1>
                    <div class="table evaluate_table">
                        <ul class="table-head">
                            <li>序号</li>
                            <li>专家姓名</li>
                            <li>评审一级指标</li>
                            <li>操作</li>
                        </ul>
                        <div class="table-body">
                            <ul class="body-item">
                                <li>1</li>
                                <li>专家1</li>
                                <li>商品管理</li>
                                <li>
                                    <a href="javascript:void(0)" class="expert_insert">添加</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div>

            </div>
        </div>

    </div>
</div>

</body>