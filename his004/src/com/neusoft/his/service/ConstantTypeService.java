package com.neusoft.his.service;

import java.util.List;

import com.neusoft.his.entity.ConstantItem;
import com.neusoft.his.entity.ConstantType;

public interface ConstantTypeService {

	/*
	 *  添加常数类型
	 *  */
	int add(ConstantType constantType) throws Exception;
	
	
	
	/*
	 *  修改常数类型
	 *  */
	int update(ConstantType constantType) throws Exception;
	
	
	
	/*
	 * 删除常数类型
	 *  */
	int delete(int id) throws Exception;
	
	
	
	/*
	 *  查询 (分页)
	 *  */
	List<ConstantType> findAll(int beginIndex,int pageSize) throws Exception;
	
	
	/*
	 * 统计记录条数
	 *  */
	int getTotalCount() throws Exception;
	
	
	ConstantType findConstantTypes(String constantTypeCode) throws Exception;
	
	
	List<ConstantItem> findConstantItem(String constantTypeCode) throws Exception;
}
