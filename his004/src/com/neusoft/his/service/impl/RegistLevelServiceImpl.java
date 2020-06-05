package com.neusoft.his.service.impl;

import java.util.List;

import com.neusoft.his.dao.RegistLevelDao;
import com.neusoft.his.dao.impl.RegistLevelDaoImpl;
import com.neusoft.his.entity.RegistLevel;
import com.neusoft.his.service.RegistLevelService;



public class RegistLevelServiceImpl implements RegistLevelService{
	private RegistLevelDao dao ;
	
	public RegistLevelServiceImpl() {
		dao = RegistLevelDaoImpl.getRegistLevelDaoImpl();
	}

	@Override
	public int add(RegistLevel registLevel) throws Exception {
		return dao.add(registLevel);
	}

	@Override
	public int update(RegistLevel registLevel) throws Exception {
		return dao.update(registLevel);
	}

	@Override
	public int delete(int id) throws Exception {
		return dao.delete(id);
	}


	@Override
	public int getTotalCount() throws Exception {
		return dao.getTotalCount();
	}

	@Override
	public List<RegistLevel> findRegistLevels(int beginIndex, int pageSize)
			throws Exception {
		return dao.findRegistLevels(beginIndex, pageSize);
	}

	@Override
	public List<RegistLevel> findAll() throws Exception {
		
		return dao.findAll();
	}

}
