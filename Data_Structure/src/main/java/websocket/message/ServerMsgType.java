package websocket.message;


/** * @author  wenchen 
 * @date 创建时间：2017年7月26日 下午3:33:29 
 * @version 1.0 
 * @parameter */
public enum ServerMsgType {
	
	数据(0),页面跳转(1);
	
	private int value;
	
	private ServerMsgType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static ServerMsgType valueOf(int value) {
		return ServerMsgType.values()[value];
	}
}
