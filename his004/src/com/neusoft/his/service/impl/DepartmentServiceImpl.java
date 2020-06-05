package com.neusoft.his.service.impl;

import java.util.List;

import com.neusoft.his.dao.DepartmentDao;
import com.neusoft.his.dao.impl.DepartmentDaoImpl;
import com.neusoft.his.entity.Department;
import com.neusoft.his.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao dao ;
	
	public DepartmentServiceImpl() {
		dao = DepartmentDaoImpl.getDepartmentDaoImpl();
	}
	
	@Override
	public List<Department> findDepartments(int beginIndex, int pageSize) throws Exception {
		
		return dao.findDepartments(beginIndex, pageSize);
	}

	@Override
	public int getTotalCount() throws Exception {
		return dao.getTotalCount();
	}

}
