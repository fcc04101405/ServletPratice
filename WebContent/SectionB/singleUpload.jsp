<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>file upload</title>
</head>
<body>
<h1>Select a file to upload</h1>
<form action="singleUpload" enctype="multipart/form-data" method="post">
	Author:<input type="text" name="author"/><br/>
	Select file to upload<input type="file" name ="filename"/><br/>
	<input type="submit" value="Upload"/>
</form>
</body>
</html>