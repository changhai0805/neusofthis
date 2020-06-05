package com.neusoft.his.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.his.dao.DepartmentDao;
import com.neusoft.his.entity.Department;
import com.neusoft.his.util.DBConnection;
import com.sun.xml.internal.ws.client.sei.StubAsyncHandler;

public class DepartmentDaoImpl implements DepartmentDao {
	
	private static DepartmentDaoImpl dao = new DepartmentDaoImpl();
	

	private DepartmentDaoImpl() {
		
	}
	
	public static DepartmentDaoImpl getDepartmentDaoImpl() {
		return dao;
	}
	@Override
	public List<Department> findDepartments(int beginIndex, int pageSize) throws Exception {
		List<Department> list = new ArrayList<Department>();
		StringBuffer sbf = new StringBuffer();
		sbf.append(" select d.* , ");
		sbf.append(" (select constantname from constantitem i where i.constrantitemid = d.DeptCategoryID) as deptCategoryName,");
		sbf.append(" (select constantname from constantitem i where i.constrantitemid = d.depttype) as deptTypeName");
		sbf.append(" from department d where delmark = 1 ");
		sbf.append(" limit ?,?");
		
		String sql = sbf.toString();
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, beginIndex);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Department d = new Department();
			d.setDepartmentId(rs.getInt("departmentid"));
			d.setDelMark(rs.getInt("delmark"));
			d.setDeptCategoryId(rs.getInt("deptcategoryid"));
			d.setDeptCategoryName(rs.getString("deptcategoryname"));
			d.setDeptCode(rs.getString("deptcode"));
			d.setDeptName(rs.getString("deptname"));
			d.setDeptType(rs.getInt("depttype"));
			d.setDeptTypeName(rs.getString("depttypename"));
			list.add(d);
			
		}
		
		DBConnection.closeAll(rs, pstmt, connection);
		return list;
	}

	@Override
	public int getTotalCount() throws Exception {
		String sql = "select count(*) from department where delmark = 1";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int i = rs.getInt(1);
		DBConnection.closeAll(rs, pstmt, connection);
		return i;
	}

	@Override
	public List<Department> findDepartments() throws Exception {
		List<Department> list = new ArrayList<Department>();
		String sql = "select * from department where delmark = 1";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Department d = new Department();
			d.setDepartmentId(rs.getInt("departmentid"));
			d.setDelMark(rs.getInt("delmark"));
			d.setDeptCategoryId(rs.getInt("deptcategoryid"));
			d.setDeptCode(rs.getString("deptcode"));
			d.setDeptName(rs.getString("deptname"));
			d.setDeptType(rs.getInt("depttype"));
			list.add(d);
			
		}
		
		DBConnection.closeAll(rs, pstmt, connection);
		return list;
	}

}
