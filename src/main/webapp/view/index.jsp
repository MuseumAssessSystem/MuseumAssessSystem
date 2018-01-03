<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>     <!--导入struts2标签库 -->
<html>
<html>
<body>
    <s:form action="User_login" method="post">
        <input type="text" name="uname" placeholder="输入用户名" />
        <br />
        <input type="password" name="password" placeholder="输入密码" />
        <br />
        <input type="submit" value="登录" />
        <input type="reset" value="重置" />
    </s:form>
</body>
</html>
