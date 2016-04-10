<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'JsonData.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.min.js"></script>  
<script type="text/javascript">
   
    function lookfor(){
    	//alert("lijian");
    	$.ajax({
    		url:"${pageContext.request.contextPath}/userController/testjson.do",
    		type:"post",
    		dataType:"json",
    		success:function(result){
    			//quanju=result;
    			console.log(quanju);
    		}
    	});
    }
    </script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <button id="button1" onclick="add()" >测试按钮，ajax调用json</button>
    <script src="//d3js.org/d3.v3.min.js"></script>
<script>
function add(){
var quanju='{"nodes":[{"name":"Myriel","group":1},{"name":"Napoleon","group":1},{"name":"Mlle.Baptistine","group":1},"links":[{"source":1,"target":0,"value":1},{"source":2,"target":0,"value":0.8}';
var width = 960,
height = 500;

var color = d3.scale.category20();

var force = d3.layout.force()
.charge(-120)
.linkDistance(30)
.size([width, height]);

var svg = d3.select("body").append("svg")
.attr("width", width)
.attr("height", height);
//此部分通过get，ajax获得控制器json数据
d3.json("${pageContext.request.contextPath}/userController/testjson.do", function(error, graph) {
if (error) throw error;

force
  .nodes(graph.nodes)
  .links(graph.links)
  .start();

var link = svg.selectAll(".link")
  .data(graph.links)
.enter().append("line")
  .attr("class", "link")
  .style("stroke-width", function(d) { return Math.sqrt(d.value); }).style("stroke","#A7A7A7");

var node = svg.selectAll(".node")
  .data(graph.nodes)
.enter().append("circle")
  .attr("class", "node")
  .attr("r", 5)
  .style("fill", function(d) { return color(d.group); })
  .call(force.drag);

node.append("title")
  .text(function(d) { return d.name; });

force.on("tick", function() {
link.attr("x1", function(d) { return d.source.x; })
    .attr("y1", function(d) { return d.source.y; })
    .attr("x2", function(d) { return d.target.x; })
    .attr("y2", function(d) { return d.target.y; });

node.attr("cx", function(d) { return d.x; })
    .attr("cy", function(d) { return d.y; });
});
});
}
</script>
  </body>
</html>
