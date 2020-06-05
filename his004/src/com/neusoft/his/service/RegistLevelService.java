package com.neusoft.his.service;

import java.util.List;

import com.neusoft.his.entity.RegistLevel;



public interface RegistLevelService {
	/*
	 *  添加常数类型
	 *  */
	int add(RegistLevel registLevel) throws Exception;
	
	
	
	/*
	 *  修改常数类型
	 *  */
	int update(RegistLevel registLevel) throws Exception;
	
	
	
	/*
	 * 删除常数类型
	 *  */
	int delete(int id) throws Exception;
	
	
	
	/*
	 *  查询 (分页)
	 *  */
	List<RegistLevel> findRegistLevels(int beginIndex, int pageSize) throws Exception;
	
	
	/*
	 * 统计记录条数
	 *  */
	int getTotalCount() throws Exception;
	
	public List<RegistLevel> findAll() throws Exception;
}
