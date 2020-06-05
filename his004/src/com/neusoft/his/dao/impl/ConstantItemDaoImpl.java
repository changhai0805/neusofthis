package com.neusoft.his.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.his.dao.ConstantItemDao;
import com.neusoft.his.entity.ConstantItem;
import com.neusoft.his.util.DBConnection;

public class ConstantItemDaoImpl implements ConstantItemDao{

	@Override
	public int add(ConstantItem constantItem) throws Exception {
		String sql = "insert into constantitem(constantTypeId,ContantCode,ContantName) values (?,?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, constantItem.getConstantTypeId());
		pstmt.setString(2, constantItem.getConstantCode());
		pstmt.setString(3, constantItem.getConstantName());
		int i = pstmt.executeUpdate();
		DBConnection.closeAll(null, pstmt, connection);
		return i;
	}

	@Override
	public int update(ConstantItem constantItem) throws Exception {
		String sql = "update constantitem set constantTypeId=?,ContantCode=?,ContantName=? where id = ? and delMark=1";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, constantItem.getConstantTypeId());
		pstmt.setString(2, constantItem.getConstantCode());
		pstmt.setString(3, constantItem.getConstantName());
		int i = pstmt.executeUpdate();
		DBConnection.closeAll(null, pstmt, connection);
		return i;
	}

	@Override
	public int delete(int id) throws Exception {
		String sql = " update constantitem set delMark = 0  where id = ?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		int i = pstmt.executeUpdate();
		DBConnection.closeAll(null, pstmt, connection);
		return i;
	}

	@Override
	public List<ConstantItem> findAll(int beginIndex, int pageSize)
			throws Exception {
		List<ConstantItem> list = new ArrayList<ConstantItem>();
		String sql = "select * from constantitem where delmark = 1  limit ?,?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, beginIndex);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ConstantItem c = new ConstantItem();
			c.setConstantItemId(rs.getInt("id"));
			c.setConstantTypeId(rs.getInt("constantTypeId"));
			c.setConstantCode(rs.getString("ContantCode"));
			c.setConstantName(rs.getString("ContantName"));
			list.add(c);
		}
		DBConnection.closeAll(rs, pstmt, connection);
		return list;
	}
	@Override
	public int getTotalCount() throws Exception {
		String sql = " select count(*) from constantitem where delmark = 1 ";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int i = rs.getInt(1);
		DBConnection.closeAll(rs, pstmt, connection);
		return i;
	}
	
}
