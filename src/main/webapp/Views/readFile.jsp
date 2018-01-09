<%--
  Created by IntelliJ IDEA.
  User: 10922
  Date: 2018/1/7
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读取文件数据</title>
</head>
<body>
　　<h2>文件下载内容：</h2>
    <br/>
    专家定性打分表.xls:<a href="FileReaderAction_readExcel.action?dxFirst=藏品管理&filePath=专家1-2008.xlsx">解析定性打分表</a><br/>
    专家定量打分表.docx<a href="FileReaderAction_readWord.action?filePath=博物馆1-2008/定量计算分数表（测试1）.docx">解析定量打分表</a>
</body>
</html>
