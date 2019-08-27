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

<body>
<script type="text/javascript">
function openfile(){
	$("[name=file]")[0].click();
	}
	
function upload(){
	var formData = new FormData();
	    formData.append("file",$("[name=file]")[0].files[0]);
	    $.ajax({
	        url:'Book/sss.action',
	        type:'post',
	        data: formData,
	        contentType: false,
	        processData: false,
	        success:function(res){
	           $(".upimg").attr("src",res);
	        }
	    });
}

</script>




<button onclick="openfile();">
测试
</button>
<button onclick="upload();">
上传
</button>
<div>
<img class="upimg" src="">
</div>

<form method="post" action="Book/sss.action" enctype="multipart/form-data" style="display:none;">
<input type="file" name="file"> 
<!-- 也需要form表单的file -->
</form>

</body>
</html>