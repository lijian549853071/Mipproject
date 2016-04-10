<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'graphtest.jsp' starting page</title>
    
		<!-- 引入 Bootstrap -->
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<style>

.node {
  stroke: #fff;
  stroke-width: 1.5px;
}

.link {
  stroke: #999;
  stroke-opacity: .6;
}

</style>
  </head>
  
  <body>
	<!--<form id="fileupload" action="${pageContext.request.contextPath}/...." method="post" enctype="multipart/form-data">
		<span style="white-space:pre">    </span>         选择文件： 
		<input type="file" name="file1" value="选择上传的文件" />
		<textarea rows="5" cols="40" name="description"></textarea>
		<input type="button" value="上传"/>
	</form>
	-->
<!--第一行编辑-->
<div id="page-inner" style="width: 100%;height: 400px;border:1px dashed #000;">		
     <!--步骤说明-->
	    <div class="row" style="margin: 5px;">
	    <div class="col-md-6 col-sm-6"style="width: 48%;float: left;">
	        <div class="panel panel-default">
	            <div class="panel-heading">使用步骤</div>
	            <div class="panel-body" style="height:350px;">
	                <ul class="nav nav-tabs">
	                    <li class="active"><a href="#home" data-toggle="tab">Step1</a>
	                    </li>
	                    <li class=""><a href="#profile" data-toggle="tab">Step2</a>
	                    </li>
	                    <li class=""><a href="#messages" data-toggle="tab">Step3</a>
	                    </li>
	                    <li class=""><a href="#settings" data-toggle="tab">Step4</a>
	                    </li>
	                </ul>
	
	                <div class="tab-content">
	                    <div class="tab-pane fade active in" id="home">
	                        <h4>步骤1</h4>
	                        <p>点击文件说明，用户输入文件格式需跟demo中的格式一致</p>
	                        <span>节点文件说明：</span><a href="#">查看demo</a><br>
           								 <span>边文件说明：</span><a href="#">查看demo</a>
	                    </div>
	                    <div class="tab-pane fade" id="profile">
	                        <h4>步骤2</h4>
	                        <p>查看用户数据库中上传的文件列表</p>
	                    </div>
	                    <div class="tab-pane fade" id="messages">
	                        <h4>步骤3</h4>
	                        <p>选择数据库中的文件，开始处理</p>
	                    </div>
	                    <div class="tab-pane fade" id="settings">
	                        <h4>步骤4</h4>
	                        <p>显示数据分析可视化结果</p>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
     <!--文件说明-->
     <div class="panel panel-primary " style="width: 40%;float: right;">
        <div class="panel-heading">
            	<span class="glyphicon glyphicon-file"></span>文件上传
        </div>
        <div class="panel-body">
					<form id="fileform" action="${pageContext.request.contextPath}/userController/upload.do" method="post" enctype="multipart/form-data">    
						选择节点文件：
						<input type="file" name="nodefile" value="选择上传的文件" class="form-control"/><br/>
						选择边文件：
						<input type="file" name="edgefile" value="选择上传的文件" class="form-control"/><br/>
						<label>文件描述：</label><br/>
						<textarea rows="5"style="width: 90%;" name="description" placeholder="输入文件描述"></textarea><br/>
						<input type="submit" value="上传" class="btn btn-default" style="float: right;"/>
						
					</form>
        </div>
     </div>
</div>
<!--第二行编辑-->
<div class="row" style="width: 100%;height:600px;border:1px dashed #000;margin-top: 5px;">        
                    <div class="panel panel-default" style="width: 48%;">
                        	<div class="panel-heading">用户数据库文件</div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>文件名称</th>
                                            <th>文件描述</th>
                                            <th>上传日期</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                     </tbody>
                                     </table>
                            </div>
        								</div>
    								  </div>
</div>
<!--第三行编辑-->
<div style="width: 100%;height:600px;border:1px dashed #000;margin-top: 5px;">
			<div class="panel panel-default" style="width: 30%;float: left;">
                    <div class="panel-heading">社团划分结果</div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>节点名称</th>
                                        <th>节点分类</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="odd gradeX">
                                        <td>Trident</td>
                                        <td>Internet Explorer 4.0</td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>Trident</td>
                                        <td>Internet Explorer 5.0</td>
                                    </tr>
                                    </tbody>
                            </table>
                        </div>
                        
                    </div>
                    </div>

			<div id="shetuanvisual" class="panel panel-primary " style="float: right;">
				        <div class="panel-heading">社团可视化</div>
					<div id="cluster" class="panel-body" style="width: 520px;height: 520px;">
				
					</div>
			</div>

<div id="cleanshow"></div>
</div>


<script src="//d3js.org/d3.v3.min.js"></script>
<script>
//function lookfor(){
//	//alert("lijian");
//	$.ajax({
//		url:"${pageContext.request.contextPath}/userController/upload.do",
//		type:"post",
//		success:function(result){
//			console(result);
//		}
//	})
//}
var width = 500,
    height = 500;

var color = d3.scale.category20();

var force = d3.layout.force()
    .charge(-120)
    .linkDistance(30)
    .size([width, height]);

var svg = d3.select("#cluster").append("svg")
    .attr("width", width)
    .attr("height", height);

d3.json("miserables.json", function(error, graph) {
  if (error) throw error;

  force
      .nodes(graph.nodes)
      .links(graph.links)
      .start();

  var link = svg.selectAll(".link")
      .data(graph.links)
    .enter().append("line")
      .attr("class", "link")
      .style("stroke-width", function(d) { return Math.sqrt(d.value); });

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

</script>
		    <!-- jQuery Js -->
    <script src="js/jquery-1.11.1.min.js"></script>
      <!-- Bootstrap Js -->
    <script src="js/bootstrap.min.js"></script>
        <!-- Metis Menu Js -->
    <script src="js/jquery.metisMenu.js"></script>
	lijian
</body>
</html>
