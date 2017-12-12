package websocket.server;

import java.io.IOException;
import java.io.InputStream;

/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月8日 上午10:42:57 
 * @version 1.0 
 * @parameter
 */
public class Receive {

	private InputStream in;

	public Receive(InputStream in) {
		this.in = in;
	}
	
	public String parse (){
		byte[] buffer = new byte[2048];//一次读取2048个字节
		StringBuilder sb = new StringBuilder(2048);
		int i;
		try {
			i=in.read(buffer);
			
		} catch (IOException e) {
			i=-1;
		}
		for (int j=0;j<i;j++){
			sb.append((char)buffer[j]);
		}
		return getUri(sb.toString());
	}
	
	private String getUri (String str){
		int index1 = str.indexOf(" "),index2;//找第一个空格
		if (index1!=-1){
			index2 = str.indexOf(" ", index1+1);//找到第一个空格后的第一个空格
			if (index2>index1){
				return str.substring(index1+1, index2);
			}
		}
		return null;
	}
}
