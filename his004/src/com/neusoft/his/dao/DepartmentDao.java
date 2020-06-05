package com.neusoft.his.dao;

import java.util.List;

import com.neusoft.his.entity.Department;

public interface DepartmentDao {

	
	List<Department> findDepartments(int beginIndex,int pageSize) throws Exception;
	
	int getTotalCount() throws Exception;
	
	
	List<Department> findDepartments() throws Exception;
}
