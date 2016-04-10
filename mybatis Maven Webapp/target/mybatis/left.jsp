<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <title>Bootstrap 实例 - 默认的导航栏</title>
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>

<body style="background:#a0a0a0;">
	<nav class="navbar navbar-default" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">导航栏</a>
   </div>
   <div class="sidebar-collapse" style="margin-bottom: 0">
      <ul class="nav navbar-nav">
         <li class="dropdown">
         	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
         	文件上传
         	<b class="caret"></b>
         	</a>
         	<ul class="dropdown-menu">
               <li><a href="#">脑电&磁共振数据</a></li>
               <li><a href="#">CT数据</a></li>
               <li><a href="#">小动物荧光成像数据</a></li>
               <li class="divider"></li>
               <li><a href="#">说明</a></li>
            </ul>
         </li>
         <li class="dropdown">
         	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
         	脑网络在线分析
         	<b class="caret"></b>
         	</a>
         	<ul class="dropdown-menu">
               <li><a href="graphtest.jsp" target="rightFrame">社团可视化</a></li>
               <li><a href="#">网络效率</a></li>
               <li><a href="#">说明</a></li>
            </ul>
         </li>
         <li><a href="#">SVN</a></li>
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
               Java 
               <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
               <li><a href="#">jmeter</a></li>
               <li><a href="#">EJB</a></li>
               <li><a href="#">Jasper Report</a></li>
               <li class="divider"></li>
               <li><a href="#">分离的链接</a></li>
               <li class="divider"></li>
               <li><a href="#">另一个分离的链接</a></li>
            </ul>
         </li>
      </ul>
   </div>
</nav>

    
</body>
</html>
