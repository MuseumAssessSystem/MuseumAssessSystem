<%--
  Created by IntelliJ IDEA.
  User: 10922
  Date: 2018/1/4
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="FileUploadAction_upload.action" enctype="multipart/form-data" method="post">
        文件:<input type="file" name="upload"><br/>
        <input type="submit" value="上传" />
    </form>
</body>
</html>
