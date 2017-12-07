package org.lf.admin.service;

import java.util.List;

import org.lf.admin.db.dao.UserMapper;
import org.lf.admin.db.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** * @author  wenchen 
 * @date 创建时间：2017年7月24日 下午3:21:11 
 * @version 1.0 
 * @parameter */
@Service
public class HomeService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getTestJson () {
		User record = new User();
		return userMapper.selectList(record);
	}
}
