package websocket.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** * @author  wenchen 
 * @date 创建时间：2017年7月27日 上午11:02:55 
 * @version 1.0 
 * @parameter */
@Target(ElementType.PARAMETER)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented 
public @interface Param {
	String value(); 
}
