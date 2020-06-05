package com.neusoft.his.service.impl;

import java.util.List;

import com.neusoft.his.dao.ConstantTypeDao;
import com.neusoft.his.dao.impl.ConstantTypeDaoImpl;
import com.neusoft.his.entity.ConstantItem;
import com.neusoft.his.entity.ConstantType;
import com.neusoft.his.service.ConstantTypeService;

public class ConstantTypeServiceImpl implements ConstantTypeService {

	private ConstantTypeDao dao;
	
	public ConstantTypeServiceImpl() {
		dao = ConstantTypeDaoImpl.getConstantTypeDaoImpl();
	}
	@Override
	public int add(ConstantType constantType) throws Exception {
		return dao.add(constantType);
	}

	@Override
	public int update(ConstantType constantType) throws Exception {
		
		return dao.update(constantType);
	}

	@Override
	public int delete(int id) throws Exception {
		
		return dao.delete(id);
	}

	@Override
	public List<ConstantType> findAll(int beginIndex, int pageSize) throws Exception {
		
		return dao.findAll(beginIndex, pageSize);
	}

	@Override
	public int getTotalCount() throws Exception {
		return dao.getTotalCount();
	}
	@Override
	public ConstantType findConstantTypes(String constantTypeCode) throws Exception {
		
		return dao.findConstantTypes(constantTypeCode);
	}

	@Override
	public List<ConstantItem> findConstantItem(String constantTypeCode) throws Exception{
		return dao.findConstantItem(constantTypeCode);
	}
}
