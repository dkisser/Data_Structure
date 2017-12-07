package utils.annotation;

import java.lang.reflect.Method;
import java.util.Arrays;

import websocket.utils.annotation.Param;
import websocket.utils.annotation.ParameterNameUtils;

/** * @author  wenchen 
 * @date 创建时间：2017年7月27日 上午11:05:57 
 * @version 1.0 
 * @parameter */
public class ParameterNameTest {
	
	 public void method1(@Param("parameter3") String param1, @Param("parameter2") String param2) {  
	        System.out.println(param1 + param2);  
	    }  
	  
	    public static void main(String[] args) throws Exception {  
	        Class<ParameterNameTest> clazz = ParameterNameTest.class;  
	        Method method = clazz.getDeclaredMethod("method1", String.class, String.class);  
	        String[] parameterNames = ParameterNameUtils.getMethodParameterNamesByAnnotation(method);  
	        System.out.println(Arrays.toString(parameterNames));  
	    }  
}
