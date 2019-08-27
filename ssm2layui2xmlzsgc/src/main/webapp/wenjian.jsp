<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<style>

</style>
<script type="text/javascript">
function testajax(){
	$("[name=file]")[0].click();
	}

</script>
<body>
<button onclick="testajax();">
测试
</button>
<form method="post" action="Book/sss.action" enctype="multipart/form-data" >
<input type="file" name="file"> 
<input name="name"> 
<input type="submit"> 
</form>
</body>
</html>