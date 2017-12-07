package websocket.server;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.lf.admin.db.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import websocket.message.BrowerMsg;
import websocket.service.Constants;
import websocket.service.ws.WebSocketService;
import websocket.utils.MessageHelper;
import websocket.utils.WebSocketConfigurator;

import com.alibaba.fastjson.JSONObject;

/** * @author  wenchen 
 * @date 创建时间：2017年5月13日 上午10:09:04 
 * @version 1.0 
 * @parameter */
@ServerEndpoint(value="/wsTest",configurator=WebSocketConfigurator.class)
public class WebSocketServer {
	
	private Session session;
	
	private static int prePreson=0;
	
	private static CopyOnWriteArraySet<WebSocketServer> set = new CopyOnWriteArraySet<WebSocketServer>();
	
	@Autowired
	private WebSocketService webSocketService;
	
	@OnOpen
	public void onOpen (Session session,EndpointConfig config) {
		HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		User user = (User)httpSession.getAttribute(Constants.LOGIN_INFO);
		this.session = session;
		try {
			if (user.getRole()>=2) {
				
				session.getBasicRemote().sendText("欢迎VIP用户来到本直播间");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		set.add(this);
		System.out.println(session.getId()+"建立连接");
		inCrease();

		for (WebSocketServer webSocketServer : set) {
			webSocketServer.sendMsgToOther("当前服务器人数:"+prePreson);
		}
	}
	
	@OnMessage
	public void onMessage (Session session , String msg) {
		System.out.println(session.getId()+"发送消息:"+msg);
		BrowerMsg msgObj = MessageHelper.parseBrowerMsg(msg);
		JSONObject result = null;
		try {
			result =(JSONObject) MessageHelper.excuteMethod(msgObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result!=null) {
			for (WebSocketServer webSocketServer : set) {
				webSocketServer.sendMsgToOther(result.toJSONString());
			}
		}
	}
	
	@OnError
	public void onError (Throwable throwable,Session session) {
		if (session.isOpen()) {
			System.err.println("error:"+throwable.getMessage());
		}
	}
	
	private void sendMsgToOther (String msg) {
		try {
			this.session.getBasicRemote().sendText(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println(session.getId()+"断开连接");
		set.remove(this);
		deCrease();
		try {
			for (WebSocketServer webSocketServer : set) {
				webSocketServer.sendMsgToOther("当前服务器人数:"+prePreson);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public synchronized void inCrease () {
		prePreson++;
	}
	
	public synchronized void deCrease () {
		prePreson--;
	}
}
