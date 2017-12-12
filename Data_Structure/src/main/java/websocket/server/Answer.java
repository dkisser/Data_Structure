package websocket.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月8日 上午10:42:47 
 * @version 1.0 
 * @parameter
 */
public class Answer {

	private OutputStream out;

	public Answer(OutputStream out) {
		this.out = out;
	}
	
	public void send (String uri){
		byte[] buffer = new byte[2048];
		FileInputStream fis = null;
		if (uri.equals("/")){
			uri=ServerTest.DEFAULT_FILE;
		}
		try {
			File file = new File(ServerTest.ROOT_DIR+uri);
			String message = null;
			if (file.exists()){
				fis = new FileInputStream(file);
				int i = fis.read(buffer, 0, 2048);
				String body = new String(buffer, 0, i);
				message = "HTTP/1.1 200 OK\r\n"+
								 "Content-Type:text/html\r\n"+
								 "Content-Length:"+i+"\r\n"+
								 "\r\n" + body;
				
			} else {
				message = "HTTP/1.1 404 File Not Found\r\n"+
								 "Content-Type:text/html\r\n"+
								 "Content-Length:23\r\n"+
								 "\r\n" + 
								 "<h1>File Not Found</h1>";
			}
			out.write(message.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
