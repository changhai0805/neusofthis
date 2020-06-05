package com.neusoft.his.service.impl;

import java.util.List;

import com.neusoft.his.dao.ConstantItemDao;
import com.neusoft.his.dao.impl.ConstantItemDaoImpl;
import com.neusoft.his.entity.ConstantItem;
import com.neusoft.his.service.ConstantItemService;

public class ConstantItemServiceImpl implements ConstantItemService{


	private ConstantItemDao dao;
	
	public ConstantItemServiceImpl() {
		dao = new ConstantItemDaoImpl();
	}
	@Override
	public int add(ConstantItem constantItem) throws Exception {
		return dao.add(constantItem);
	}

	@Override
	public int update(ConstantItem constantItem) throws Exception {
		
		return dao.update(constantItem);
	}

	@Override
	public int delete(int id) throws Exception {
		
		return dao.delete(id);
	}

	@Override
	public List<ConstantItem> findAll(int beginIndex, int pageSize) throws Exception {
		
		return dao.findAll(beginIndex, pageSize);
	}

	@Override
	public int getTotalCount() throws Exception {
		return dao.getTotalCount();
	}

}
