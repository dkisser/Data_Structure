package websocket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月8日 上午10:41:15 
 * @version 1.0 
 * @parameter
 */
public class MyServer extends Thread{
	
	private Socket socket;
	
	public MyServer(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream in = null;
		OutputStream out = null;
		try {
			//获得输入流，并将输入流解析成对应的物理地址
			in = socket.getInputStream();
			Receive receive = new Receive(in);
			String uri = receive.parse();
			//获得输出流，并将物理地址的文件读取，然后用output输出
			out = socket.getOutputStream();
			Answer answer = new Answer(out);
			answer.send(uri);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}
