<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date" %>
    <%@page import="java.text.DateFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--HTML/XHTML备注-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Today's date</title>
</head>
<body>
    <%--返回日期 jsp备注--%>
<%
DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.LONG);
String s=dateFormat.format(new Date());
out.println("Today is "+s);
%>
</body>
</html>