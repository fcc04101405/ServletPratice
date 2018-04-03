<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!public void jspInit() {
		System.out.println("jspInit。。。");
	}

	public void jspDestroy() {
		System.out.println("jspDestroy...");
	}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jspInit and jspDestroy</title>
</head>
<body>Overriding jspInit and jspDestroy
</body>
</html>