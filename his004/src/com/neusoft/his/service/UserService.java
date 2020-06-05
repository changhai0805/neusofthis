package com.neusoft.his.service;

import java.util.List;
import java.util.Map;

import com.neusoft.his.entity.User;

public interface UserService {

	User findUserByUnamePwd(String username,String password) throws Exception;
	
	List<User> findUsers(int beginIndex,int pageSize) throws Exception;
	
	
	int getTotalCount() throws Exception;
	
	public Map<String , List> findAddUserInfo() throws Exception;
}
