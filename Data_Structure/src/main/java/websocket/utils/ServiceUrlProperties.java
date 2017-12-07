package websocket.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** * @author  wenchen 
 * @date 创建时间：2017年7月26日 下午5:17:34 
 * @version 1.0 
 * @parameter */
public class ServiceUrlProperties {

	public static Properties serviceUrlProperties;
	
	
	static {
		InputStream inputStream = ServiceUrlProperties.class.getClassLoader().getResourceAsStream("ServiceUrlProperties.properties");
		serviceUrlProperties = new Properties();
		try {
			serviceUrlProperties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
		
	}
	
	public static String getProperty (String name) {
		String result = serviceUrlProperties.getProperty(name);
		if (result.equals("")) {
			return null;
		} else {
			return result.trim();
		}
	}
	
}
