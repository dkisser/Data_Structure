function getContextPath() {
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	return localObj.protocol + "//" + localObj.host + "/" + contextPath;
}

function parseServerMsg (jsonStr) {
	var json = eval("("+jsonStr+")");
	if (json.action == 1) {
		window.location.href = getContextPath() + json.data[0];
	} else if (json.action == 0) {
		return json.data;//这个地方返回的是一个JSONArray
	} else {
		return  null;
	}
	
}

function compactMsg (serviceName,methodName,data) {
	if (data == null) {
		return "{\"methodName\":\""+methodName+"\",\"serviceName\":\""+serviceName+"\"}";
	}
	return "{\"methodName\":\""+methodName+"\",\"serviceName\":\""+serviceName+"\",\"data\":"+data+"}";
}



