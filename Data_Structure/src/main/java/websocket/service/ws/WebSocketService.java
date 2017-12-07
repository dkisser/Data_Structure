package websocket.service.ws;

import websocket.message.ServerMsgType;
import websocket.utils.MessageHelper;
import websocket.utils.annotation.Param;

import com.alibaba.fastjson.JSONObject;

/** * @author  wenchen 
 * @date 创建时间：2017年7月26日 下午4:34:09 
 * @version 1.0 
 * @parameter */
public class WebSocketService {

	public void sayHello (@Param("pid")Integer id,@Param("id")Integer pid) {
		System.out.println("hello!");
	}
	
	public JSONObject toBaidu () {
		return MessageHelper.parseURL("/MyJsp.jsp", ServerMsgType.页面跳转.getValue());
	}
	
}
