<%@ tag language="java" pageEncoding="UTF-8" import="java.util.Date" import="java.text.DateFormat"%>
<%
	DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.LONG);
	Date now=new Date(System.currentTimeMillis());
	out.println(dateFormat.format(now));
%>
