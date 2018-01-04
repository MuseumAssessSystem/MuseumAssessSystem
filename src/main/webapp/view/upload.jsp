<%--
  Created by IntelliJ IDEA.
  User: 10922
  Date: 2018/1/4
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
  <head>
      <title>文件上传</title>
      </head>

  <body>

    <s:form action="UploadAction_upload" method="post" enctype="multipart/form-data">
        <s:file name="word" label="file"></s:file>
        <s:textfield  name="wordList[0]" label="wordList"></s:textfield>

        <s:file name="ppt" label="wordfile"></s:file>
        <s:textfield  name="wordLst[1]" label="PPTDesc"></s:textfield>

        <s:file name="ppt" label="PPTfile"></s:file>
        <s:textfield  name="pptDesc[2]" label="PPTDesc"></s:textfield>

        <s:file name="ppt" label="PPTfile"></s:file>
        <s:textfield  name="pptDesc[3]" label="PPTDesc"></s:textfield>

        <s:submit></s:submit>
    </s:form>
  </body>
</html>
