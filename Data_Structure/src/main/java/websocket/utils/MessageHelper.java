package websocket.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import websocket.message.BrowerMsg;
import websocket.utils.annotation.ParameterNameUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/** * @author  wenchen 
 * @date 创建时间：2017年7月26日 下午3:51:14 
 * @version 1.0 
 * @parameter */
public class MessageHelper {
	
	/**
	 * 功能:将一个java对象变成前台接收的数据对象
	 * @param obj
	 * @param action
	 * @return
	 */
	public static JSONObject parseObject (Object obj,Integer action) {
		JSONObject resultObject = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
		jsonArr.add(jsonObject);
		resultObject.put("action", action);
		resultObject.put("data", jsonArr);
		return resultObject;
	}
	
	/**
	 * 功能:将List变成前台接受的对象
	 * @param list
	 * @param action
	 * @return
	 */
	public static JSONObject parseList (List list,Integer action) {
		JSONObject resultObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		for (Object o : list) {
			JSONObject jsonObject = (JSONObject) JSONObject.toJSON(o);
			jsonArr.add(jsonObject);
		}
		resultObj.put("action", action);
		resultObj.put("data", jsonArr);
		return resultObj;
	}
	
	/**
	 * 功能:将url变成前台接受的对象
	 * @param url
	 * @param action
	 * @return
	 */
	public static JSONObject parseURL (String url,Integer action) {
		JSONObject resultObject = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		jsonArr.add(url);
		resultObject.put("action", action);
		resultObject.put("data", jsonArr);
		return resultObject;
	}
	
	/**
	 * 功能:将前台的str变成BroweMsg方便后台解析
	 * 只能接受{"aaa":"bbb"}这种形式的数据
	 * @param str
	 * @return
	 */
	public static BrowerMsg parseBrowerMsg (String str) {
		
		JSONObject msgObj = JSONObject.parseObject(str);
		String methodName = msgObj.getString("methodName");
		String serviceName = msgObj.getString("serviceName");
		JSONObject data = msgObj.getJSONObject("data");
		BrowerMsg result = new BrowerMsg();
		result.setServiceName(serviceName);
		result.setMethodName(methodName);
		result.setData(data);
		return result;
		
	}
	
	/**
	 * 功能；根据传入的方法名和类所在的位置来执行这个方法
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws ClassNotFoundException 
	 */
	public static Object excuteMethod (BrowerMsg msgObj) throws Exception {
		Class<?> webClass = Class.forName(ServiceUrlProperties.getProperty(msgObj.getServiceName()));
		Method[] methods = webClass.getMethods();
		Object result = null;
		for (Method m : methods) {
			if (m.getName().equals(msgObj.getMethodName())) {
				//先调用ParameterNameUtils获取参数的名称
		        String[] parameterNames = ParameterNameUtils.getMethodParameterNamesByAnnotation(m); 
		        Object[] obj = null;
		        if (parameterNames != null) {
		        	obj = new Object [parameterNames.length] ;
		        	int i = 0;
		        	if (msgObj.getData()!=null){
		        		for (String str : parameterNames) {
		        			obj[i++] = msgObj.getData().get(str);
		        		}
		        	}
		        }
				result = m.invoke(webClass.newInstance(),obj);
				break;
			}
		}
		return result;
	}
	
}
