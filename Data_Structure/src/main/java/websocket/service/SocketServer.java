package websocket.service;

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

import websocket.utils.WebSocketConfigurator;

@ServerEndpoint(value="/ws",configurator=WebSocketConfigurator.class)
public class SocketServer {
	
	public static  CopyOnWriteArraySet<SocketServer> set = new CopyOnWriteArraySet<SocketServer>();
	
	private Session session;
	
	private static int preCount;
	
	/**
	 * ���ͻ������������������ʱִ��
	 * @param session
	 */
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
		increase();

		for (SocketServer SocketServer : set) {
			SocketServer.sendMsgToOther("当前服务器人数:"+preCount);
		}
	}
	
	/**
	 * ���ͻ��˷�������ʱִ��
	 * @param msg
	 * @param session
	 */
	@OnMessage
	public void onMessage (String msg,Session session) {
		System.out.println(session.getId()+"前台发来消息："+msg);
		for (SocketServer socketServer:set) {
			socketServer.sendMsgToOther(msg);
		}
	}
	
	private void sendMsgToOther (String msg) {
		try {
			this.session.getBasicRemote().sendText(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnError
	public void onError (Session session,Throwable throwable) {
		if (session.isOpen()) {
			System.err.println("error:"+throwable.getMessage());
		}
	}
	
	@OnClose
	public void onClose (Session session) {
			
		set.remove(this);
		try {
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		decrease();
		System.out.println(session.getId()+"断开连接");
	}
	
	private static synchronized void increase () {
		preCount++;
	}
	
	private static synchronized void decrease () {
		preCount--;
	}
}
