package org.lf.admin.action;

import org.lf.admin.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

/** * @author  wenchen 
 * @date 创建时间：2017年7月24日 下午3:13:30 
 * @version 1.0 
 * @parameter */
@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	private final String ROOT_URL="/";

	@RequestMapping("getTestJson.do")
	@ResponseBody
	public String getTestJson (String callback) {
		JSONArray arr = (JSONArray) JSONArray.toJSON(homeService.getTestJson());
		return callback + "("+arr+")";
	}
	
	@RequestMapping("loginUI.do")
	public String loginUI() {
		return ROOT_URL+"loginUI";
	}
	
}
