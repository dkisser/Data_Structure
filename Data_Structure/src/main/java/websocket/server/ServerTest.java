package websocket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月8日 上午10:45:32 
 * @version 1.0 
 * @parameter
 */
public class ServerTest {
	
	public static final String ROOT_DIR="d:\\wwwTest";
	
	public static final String DEFAULT_FILE="/index.html";
	
	public static void main(String[] args) {
		ServerSocket socket;
		try {
			socket = new ServerSocket(666);
			System.out.println("Wait For Connect!");
			while (true){
				Socket s = socket.accept();
				System.out.println("Accept Connect!");
				new MyServer(s).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
