package org.lf.admin.db.dao;

import java.util.List;

import org.lf.admin.db.pojo.User;


public interface UserMapper extends BaseMapper<User>{
    int deleteByPrimaryKey(String uname);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uname);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //根据uname进行模糊查找
    List<User> getUserFuzzy(User user);
    
    int countUserList(User user);
    
}