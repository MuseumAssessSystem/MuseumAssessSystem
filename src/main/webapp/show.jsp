<%--
  Created by IntelliJ IDEA.
  User: 10922
  Date: 2018/1/9
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.io.*"%>
<%
    response.reset();
    String path = new String(request.getParameter("path").getBytes("iso-8859-1"),"utf-8");
    System.out.println(path);
    response.setContentType("application/vnd.ms-excel");
    InputStream ips = new FileInputStream(path);
    OutputStream ops = response.getOutputStream();

    int data = -1;
    while((data = ips.read())!=-1){
        ops.write(data);
    }
    ops.close();
%>