package com.neusoft.his.dao;

import java.util.List;

import com.neusoft.his.entity.ConstantItem;


public interface ConstantItemDao {
	/*
	 *  添加常数类型
	 *  */
	int add(ConstantItem constantItem) throws Exception;
	
	
	
	/*
	 *  修改常数类型
	 *  */
	int update(ConstantItem constantItem) throws Exception;
	
	
	
	/*
	 * 删除常数类型
	 *  */
	int delete(int id) throws Exception;
	
	
	
	/*
	 *  查询 (分页)
	 *  */
	List<ConstantItem> findAll(int beginIndex,int pageSize) throws Exception;
	
	
	/*
	 * 统计记录条数
	 *  */
	int getTotalCount() throws Exception;
	
}


