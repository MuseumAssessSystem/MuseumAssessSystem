<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 10922
  Date: 2018/1/5
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
<head>
    <title>test_download</title>
</head>
<body>
　　<h2>文件下载内容：</h2>
<br/>
<!-- 下载单个文件 -->
通讯录.xls:<a href="DownlodaAction_download.action?filename=E:\Files\dxassess\专家1-2008.xlsx">点击下载</a><br/>
<!-- 下载压缩文件 -->
<!--<a href="DownZipAction_downloadzip.action">点击下载</a><br/>-->
</body>
</html>
