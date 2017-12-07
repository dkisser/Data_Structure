package websocket.message;

import com.alibaba.fastjson.JSONObject;

/** * @author  wenchen 
 * @date 创建时间：2017年7月27日 下午12:31:17 
 * @version 1.0 
 * @parameter */
public class ServerMsg {
	
	private Integer action;
	
	private JSONObject data;

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}
	
	
	
}
