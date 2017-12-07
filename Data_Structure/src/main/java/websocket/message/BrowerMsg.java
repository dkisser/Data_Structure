package websocket.message;

import com.alibaba.fastjson.JSONObject;

/** * @author  wenchen 
 * @date 创建时间：2017年7月26日 下午4:29:41 
 * @version 1.0 
 * @parameter */
public class BrowerMsg {
	
	private String serviceName;
	
	private String methodName;
	
	private JSONObject data;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}
	
}
