package com.neusoft.his.dao;

import java.util.List;

import com.neusoft.his.entity.ConstantType;
import com.neusoft.his.entity.RegistLevel;

public interface RegistLevelDao {

	public List<RegistLevel> findRegistLevels(int beginIndex, int pageSize) throws Exception;
	
	int getTotalCount() throws Exception;
	
	public List<RegistLevel> findAll() throws Exception;
	/*
	 *  添加常数类型
	 *  */
	int add(RegistLevel registLevel) throws Exception;

	
	/*
	 *  修改常数类型
	 *  */
	int update(RegistLevel registLevel) throws Exception;
	
	int delete(int id) throws Exception;
}
