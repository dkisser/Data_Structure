<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/layui/css/layui.css">
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/home.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/layui/layui.js"></script>
  </head>
  
<body>
  <input id="test"/> <button id="submit" onclick="sendMsgToServer()">提交</button>
  
<script type="text/javascript">

function $ (selector) {
	return document.querySelector(selector);
}

var ws;
layui.use(['jquery', 'layer'], function(){ 
	  var $ = layui.jquery //重点处
	  ,layer = layui.layer;
	  
	  //后面就跟你平时使用jQuery一样
	  $('body').append('hello jquery');
	});
(function () {
	ws = new WebSocket("ws://localhost:8080/Data_Structure/wsTest");
	if (typeof(WebSocket) !== "undefined") {
		console.log("支持WebSocket!");
		
		ws.onopen = function () {

		};
		
		ws.onmessage = function (event) {
			parseServerMsg(event.data);
		};
	}
	window.onbeforeunload = function(){    
		ws.close();    
	};
})();


function sendMsgToServer () {
	var msg = $("#test").value;
	msg = compactMsg("WebSocketService",msg,null);
	ws.send(msg);
}

</script>  
</body>
</html>
