package com.neusoft.his.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.his.dao.ConstantTypeDao;
import com.neusoft.his.entity.ConstantItem;
import com.neusoft.his.entity.ConstantType;
import com.neusoft.his.util.DBConnection;

public class ConstantTypeDaoImpl implements ConstantTypeDao {
	private static ConstantTypeDaoImpl dao = new ConstantTypeDaoImpl();
	private ConstantTypeDaoImpl() {
		
	}
	
	public static ConstantTypeDaoImpl getConstantTypeDaoImpl() {
		return dao;
	}

	@Override
	public int add(ConstantType constantType) throws Exception {
		String sql = "insert into constanttype(constantTypeCode,constantTypeName) values(?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, constantType.getConstantTypeCode());
		pstmt.setString(2, constantType.getConstantTypeName());
		int i = pstmt.executeUpdate();
		DBConnection.closeAll(null, pstmt, connection);
		return i;
	}

	@Override
	public int update(ConstantType constantType) throws Exception {
		String sql = " update constanttype set constantTypeCode=?,constantTypeName=?  where constanttypeid = ?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, constantType.getConstantTypeCode());
		pstmt.setString(2, constantType.getConstantTypeName());
		pstmt.setInt(3, constantType.getId());
		int i = pstmt.executeUpdate();
		DBConnection.closeAll(null, pstmt, connection);
		return i;
		
	}

	
	@Override
	public int delete(int id) throws Exception {
		String sql = " update constanttype set delMark = 0  where constanttypeid = ?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		int i = pstmt.executeUpdate();
		DBConnection.closeAll(null, pstmt, connection);
		return i;
	}

	
	@Override
	public List<ConstantType> findAll(int beginIndex, int pageSize) throws Exception {
		List<ConstantType> list = new ArrayList<ConstantType>();
		String sql = "select * from constanttype where delmark = 1  limit ?,?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, beginIndex);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ConstantType c = new ConstantType();
			c.setId(rs.getInt("constanttypeid"));
			c.setConstantTypeCode(rs.getString("constanttypecode"));
			c.setConstantTypeName(rs.getString("constantTypeName"));
			c.setDelMark(rs.getInt("delMark"));
			list.add(c);
		}
		DBConnection.closeAll(rs, pstmt, connection);
		return list;
	}

	@Override
	public int getTotalCount() throws Exception {
		
		String sql = " select count(*) from constanttype where delmark = 1 ";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int i = rs.getInt(1);
		DBConnection.closeAll(rs, pstmt, connection);
		return i;
	}

	@Override
	public ConstantType findConstantTypes(String constantTypeCode) throws Exception {
		List<ConstantType> list = new ArrayList<ConstantType>();
		String sql ="SELECT t.*, i.constrantitemid,i.ConstantCode,i.ConstantName" + 
				" from constanttype t, constantitem i" + 
				" where t.constanttypeid = i.constantTypeID" + 
				" and t.constantTypeCode = ?"; 
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, constantTypeCode);
		ResultSet rs = pstmt.executeQuery();
		List<ConstantItem> list2 = new ArrayList<ConstantItem>();
		ConstantType t = new ConstantType();
		while(rs.next()) {
			
			t.setId(rs.getInt("constanttypeid"));
			t.setConstantTypeCode(rs.getString("constanttypecode"));
			t.setConstantTypeName(rs.getString("constanttypename"));
			t.setDelMark(rs.getInt("delMark"));
			ConstantItem i = new ConstantItem();
			i.setConstantItemId(rs.getInt("constrantitemid"));
			i.setConstantCode(rs.getString("constantcode"));
			i.setConstantName(rs.getString("constantname"));
			list2.add(i);
			
		}
		
		
		t.setConstantItems(list2);
		
		
		
		DBConnection.closeAll(rs, pstmt, connection);
		return t;
	}

	@Override
	public List<ConstantItem> findConstantItem(String constantTypeCode) throws Exception {
	    String sql = "SELECT i.* " + 
	    		" from constanttype t, constantitem i" + 
	    		" where t.constanttypeid = i.constantTypeID" + 
	    		" and t.constantTypeCode = ?" ;
	    
	    
	    List<ConstantItem> list = new ArrayList<ConstantItem>();
	    Connection connection = DBConnection.getConnection();
	    PreparedStatement pstmt = connection.prepareStatement(sql);
	    pstmt.setString(1, constantTypeCode);
	    ResultSet rs = pstmt.executeQuery();
	    while(rs.next()) {
	    	ConstantItem constantItem = new ConstantItem();
	    	constantItem.setConstantItemId(rs.getInt("constrantitemid"));
	    	constantItem.setConstantCode(rs.getString("constantcode"));
	    	constantItem.setConstantName(rs.getString("constantname"));
	    	constantItem.setDelMark(rs.getInt("delmark"));
	    	constantItem.setConstantTypeId(rs.getInt("constanttypeid"));
	    	list.add(constantItem);
	    }
	    DBConnection.closeAll(rs, pstmt, connection);
		return list;
	}

}
