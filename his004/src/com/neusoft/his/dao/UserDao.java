package com.neusoft.his.dao;

import java.util.List;

import com.neusoft.his.entity.User;

public interface UserDao {

	
	User findUserByUnamePwd(String username,String password) throws Exception;
	
	List<User> findUsers(int beginIndex,int pageSize) throws Exception;
	
	int getTotalCount() throws Exception;
	
}
