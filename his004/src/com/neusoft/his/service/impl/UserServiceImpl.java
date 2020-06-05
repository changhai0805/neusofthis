package com.neusoft.his.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neusoft.his.dao.ConstantTypeDao;
import com.neusoft.his.dao.DepartmentDao;
import com.neusoft.his.dao.RegistLevelDao;
import com.neusoft.his.dao.UserDao;
import com.neusoft.his.dao.impl.ConstantTypeDaoImpl;
import com.neusoft.his.dao.impl.DepartmentDaoImpl;
import com.neusoft.his.dao.impl.RegistLevelDaoImpl;
import com.neusoft.his.dao.impl.UserDaoImpl;
import com.neusoft.his.entity.ConstantItem;
import com.neusoft.his.entity.Department;
import com.neusoft.his.entity.RegistLevel;
import com.neusoft.his.entity.User;
import com.neusoft.his.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao;
	
	private ConstantTypeDao constantTypeDao;
	
	private DepartmentDao departmentDao;
	
	private RegistLevelDao registLevelDao;
	
	
	public UserServiceImpl() {
		
		dao = UserDaoImpl.getUserDaoImpl();
		
		constantTypeDao = ConstantTypeDaoImpl.getConstantTypeDaoImpl();
		
		departmentDao = DepartmentDaoImpl.getDepartmentDaoImpl();
		
		registLevelDao = RegistLevelDaoImpl.getRegistLevelDaoImpl();
		
		
	}
	@Override
	public User findUserByUnamePwd(String username, String password) throws Exception {
		return dao.findUserByUnamePwd(username, password);
	}

	@Override
	public List<User> findUsers(int beginIndex, int pageSize) throws Exception {
		return dao.findUsers(beginIndex, pageSize);
	}
	@Override
	public int getTotalCount() throws Exception {
		
		return dao.getTotalCount();
	}

	
	 public Map<String , List> findAddUserInfo() throws Exception{
		 Map<String , List> map = new HashMap<String, List>();
		 //获取用户类型
		 List<ConstantItem> usertypeList = constantTypeDao.findConstantItem("YHLX");
		 //获取职称列表
		 List<ConstantItem> docTitleList = constantTypeDao.findConstantItem("YSZC");
		 //获取科室列表
		 List<Department> deptList = departmentDao.findDepartments();
		 //获取挂号级别 
		 List<RegistLevel> registlevelList = registLevelDao.findAll();
		 
		 
		 //将各个list存放到map中
		 map.put("usertypes", usertypeList);
		 map.put("depts", deptList);
		 map.put("reglevels", registlevelList);
		 map.put("doctitles", docTitleList);
		 return map;
	 }
}
