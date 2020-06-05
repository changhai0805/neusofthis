package com.neusoft.his.service;

import java.util.List;

import com.neusoft.his.entity.Department;

public interface DepartmentService {

    List<Department> findDepartments(int beginIndex,int pageSize) throws Exception;
	
	int getTotalCount() throws Exception;
}
