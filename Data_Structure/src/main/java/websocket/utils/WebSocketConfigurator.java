package websocket.utils;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;



/** * @author  wenchen 
 * @date 创建时间：2017年7月28日 下午4:05:59 
 * @version 1.0 
 * @parameter */
public class WebSocketConfigurator extends Configurator{

	@Override
	public void modifyHandshake(ServerEndpointConfig sec,
			HandshakeRequest request, HandshakeResponse response) {
		super.modifyHandshake(sec, request, response);
		
		HttpSession session = (HttpSession) request.getHttpSession();
		sec.getUserProperties().put(HttpSession.class.getName(), session);
	}

	
	
	
}
