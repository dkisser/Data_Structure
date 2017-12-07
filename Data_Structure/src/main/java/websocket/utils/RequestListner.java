package websocket.utils;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/** * @author  wenchen 
 * @date 创建时间：2017年7月28日 下午3:58:48 
 * @version 1.0 
 * @parameter */
@WebListener
public class RequestListner implements ServletRequestListener{

	public RequestListner() {
		super();
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		
		((HttpServletRequest) sre.getServletRequest()).getSession();
	}

}
