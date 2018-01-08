<%@ page import="javax.swing.*" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
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
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="./Common/Import.jsp"/>

    <link rel="stylesheet" type="text/css" href="/Content/Styles/user.css">

    <script type="text/javascript" src="/Content/Scripts/user.js"></script>
</head>
<body>
<div class="page-wrapper">
    <!-- 导航栏 -->
    <div class="nav-wrap">
        <%@ include file="./Common/Navbar.jsp"%>
    </div>
    <div class="content-wrap">
        <!-- header -->
        <div class="header-wrap">
            <%@ include file="./Common/Header.jsp"%>
        </div>
        <!-- 内容区 -->
        <div class="container-wrap">
            <div class="container">

                <div class="mask"></div>

                <h1>用户管理</h1>

                <div class="search" id="search-by-name">
                    <form action="UserAction_getUserByUname">
                        <input type="text" name="username" placeholder="按用户名称搜索...">
                        <button type="submit"></button>
                    </form>
                </div>

                <div class="op-btns">
                    <div class="op-btn">
                        <a href="UserAction_addUser.action" class="insert_user">添加用户</a>
                    </div>
                </div>

                <div class="table user_list">
                    <ul class="table-head">
                        <li>序号</li>
                        <li>用户名</li>
                        <li>用户类型</li>
                        <li>email</li>
                        <li>手机号</li>
                        <li>操作</li>
                    </ul>
                    <div class="table-body">

                    <s:if test="#session.userList.size()!=0">
                     <s:iterator value="#session.userList" var="user">
                        <ul class="body-item">
                            <li>1</li>
                            <li><s:property value="#user.uname"></s:property> </li>
                            <li><s:property value="#user.rname"></s:property> </li>
                            <li><s:property value="#user.email"></s:property> </li>
                            <li><s:property value="#user.phone"></s:property> </li>
                            <li>
                                <a href="" class="alter">修改</a>
                                <a href="UserAction_deleteUser.action?uid=${user.uid}" class="delete">删除</a>
                            </li>
                        </ul>
                     </s:iterator>
                    <s:else>没有查询到用户...</s:else>
                    </s:if>
                    </div>
                </div>

                <!-- 添加用户-->
                <div class="pop-up" id="insert_user">
                    <h2>添加用户</h2>
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
                                        <select class="user_type" name="user_type">
                                            <option value="">系统管理员</option>
                                            <option value="">专家管理员</option>
                                            <option value="">博物馆管理员</option>
                                            <option value="">评审人员</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    密码：
                                </td>
                                <td>
                                    <form>
                                        <input type="password" name="input_password" class="input" id="input_password">
                                        <span class="word_note">6-10个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>email</td>
                                <td>
                                    <form>
                                        <input type="email" name="input_email" class="input" id="input_email">
                                        <span class="word_note">最多60个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>手机号码</td>
                                <td>
                                    <form>
                                        <input type="telephone" name="input_tel" class="input" id="input_tel">
                                        <span class="word_note">11为手机号码</span>
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

                <!-- 用户信息修改-->
                <form action="UserAction_updateUser">
                <div class="pop-up" id="alter_user">
                    <h2>用户信息修改</h2>
                    <div class="table">
                        <table>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    用户名称：
                                </td>
                                <td>
                                    <form>
                                        <input type="text" name="update_user" class="input" id="update_user">
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
                                        <select class="user_type" name="user_type">
                                            <option value="">系统管理员</option>
                                            <option value="">专家管理员</option>
                                            <option value="">博物馆管理员</option>
                                            <option value="">评审人员</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    密码：
                                </td>
                                <td>
                                    <form>
                                        <input type="password" name="update_password" class="input" id="update_password">
                                        <span class="word_note">6-10个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">*</span>
                                    请在次输入密码：
                                </td>
                                <td>
                                    <form>
                                        <input type="password" name="update_password_again" class="input" id="update_password_again">
                                        <span class="word_note">6-10个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>email</td>
                                <td>
                                    <form>
                                        <input type="email" name="update_email" class="input" id="update_email">
                                        <span class="word_note">最多60个字符</span>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>手机号码</td>
                                <td>
                                    <form>
                                        <input type="telephone" name="update_tel" class="input" id="update_tel">
                                        <span class="word_note">11为手机号码</span>
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
                </form>
            </div>
            <div class="container">
                <div class="mask"></div>
                <!--用户角色管理-->
                <h1>角色管理</h1>
                <div class="table user_manage">
                    <ul class="table-head">
                        <li>序号</li>
                        <li>类别名称</li>
                        <li>角色介绍</li>
                        <li>操作</li>
                    </ul>
                    <div class="table-body">
                        <s:if test="#session.roleList.size()!=0">
                            <s:iterator value="#session.roleList" var="role">
                        <ul class="body-item">
                            <li>1</li>
                            <li><s:property value="#role.rname"></s:property> </li>
                            <li><s:property value="#role.description"></s:property> </li>
                            <li>
                                <a href="javascript:void(0);" class="search_power">查看权限</a>
                                <a href="javascript:void(0);" class="edit_power">编辑权限</a>
                            </li>
                        </ul>
                            </s:iterator>
                        </s:if>
                    </div>
                </div>

                <!-- 编辑权限-->
                <div class="pop-up" id="editor_power">
                    <h2>编辑权限</h2>
                    <div class="table">
                        <ul>
                            <li class="editor_li">权限信息:</li>
                            <li class="editor_li">
                                <form>
                                    <label><input name="power" type="checkbox" value="" />申报书管理 </label>
                                    <label><input name="power" type="checkbox" value="" />打分表管理 </label>
                                    <label><input name="power" type="checkbox" value="" />计算管理 </label>
                                    <label><input name="power" type="checkbox" value="" />统计表管理</label>
                                    <label><input name="power" type="checkbox" value="" />排名管理 </label>
                                    <label><input name="power" type="checkbox" value="" />博物馆管理 </label>
                                    <label><input name="power" type="checkbox" value="" />专家管理 </label>
                                    <label><input name="power" type="checkbox" value="" />用户管理</label>
                                </form>
                            </li>
                        </ul>
                    </div>

                    <div class="button_style">
                        <button>提交</button>
                        <button class="close">取消</button>
                    </div>
                </div>

                <!-- 查看权限-->
                <div class="pop-up" id="searcher_power">
                    <h2>查看权限</h2>
                    <s:if test="#session.pris.size()!=0">
                        <s:iterator value="#session.pris" var="pri">
                    <div class="table add_li">
                        <ol>
                            <li class="searcher_li_top">权限：</li>
                            <li class="searcher_li"><s:property value="#pri.pname"></s:property></li>
                        </ol>
                    </div>
                    </s:iterator>
                    </s:if>
                    <div class="button_style">
                        <button>提交</button>
                        <button class="close">取消</button>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>
</body>
</html>
