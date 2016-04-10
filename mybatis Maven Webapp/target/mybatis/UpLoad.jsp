<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">上传文件</h1><hr color="red">  
    <form action="${pageContext.request.contextPath}/userController/upload.do" method="POST"   
        enctype="multipart/form-data">  
        选择文件：<input type="file" name="upload"/><br>  
        <b>资源描述：</b><br>  
        <textarea rows="5" cols="40" name="description"></textarea><br>  
        <input type="submit" value="上传"/>  
    </form>  
</body>
</html>