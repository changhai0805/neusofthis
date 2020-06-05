package com.neusoft.his.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.his.dao.RegistLevelDao;
import com.neusoft.his.entity.ConstantType;
import com.neusoft.his.entity.RegistLevel;
import com.neusoft.his.util.DBConnection;

public class RegistLevelDaoImpl implements RegistLevelDao {

	private static RegistLevelDaoImpl dao = new RegistLevelDaoImpl();
	
	public static RegistLevelDaoImpl getRegistLevelDaoImpl() {
		return dao;
	}
	
	private RegistLevelDaoImpl() {
		
	}
	
	
	@Override
	public List<RegistLevel> findRegistLevels(int beginIndex, int pageSize) throws Exception {
		String sql = "select * from registlevel where delmark = 1";
		Connection connection = DBConnection.getConnection();
		List<RegistLevel> list = new ArrayList<RegistLevel>();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			RegistLevel r = new RegistLevel();
			r.setDelMark(rs.getInt("delmark"));
			r.setRegistCode(rs.getString("registcode"));
			r.setRegistFee(rs.getDouble("registfee"));
			r.setRegistLevelId(rs.getInt("registlevelid"));
			r.setRegistName(rs.getString("registname"));
			r.setRegistQuota(rs.getInt("registQuota"));
			r.setSequenceNo(rs.getInt("sequenceno"));
			list.add(r);
		}
		DBConnection.closeAll(rs, pstmt, connection);
		return list;
	}

	@Override
	public int getTotalCount() throws Exception {
		String sql = "select count(*) from registlevel where delmark = 1";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int i = rs.getInt(1);
		DBConnection.closeAll(rs, pstmt, connection);
		return i;
	}

	@Override
	public List<RegistLevel> findAll() throws Exception {
		String sql = "select * from registlevel where delmark = 1";
		Connection connection = DBConnection.getConnection();
		List<RegistLevel> list = new ArrayList<RegistLevel>();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			RegistLevel r = new RegistLevel();
			r.setDelMark(rs.getInt("delmark"));
			r.setRegistCode(rs.getString("registcode"));
			r.setRegistFee(rs.getDouble("registfee"));
			r.setRegistLevelId(rs.getInt("registlevelid"));
			r.setRegistName(rs.getString("registname"));
			r.setRegistQuota(rs.getInt("registQuota"));
			r.setSequenceNo(rs.getInt("SequenceNo"));
			list.add(r);
		}
		DBConnection.closeAll(rs, pstmt, connection);
		return list;
	}

	@Override
	public int delete(int id) throws Exception {
		String sql = " update registlevel set delMark = 0  where registlevelid = ?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		int i = pstmt.executeUpdate();
		DBConnection.closeAll(null, pstmt, connection);
		return i;
	}

	@Override
	public int add(RegistLevel registLevel) throws Exception {
		String sql = "insert into registlevel(registcode,registname,sequenceno,registfee,registquota) values(?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, registLevel.getRegistCode());
		pstmt.setString(2, registLevel.getRegistName());
		pstmt.setInt(3, registLevel.getSequenceNo());
		pstmt.setDouble(4, registLevel.getRegistFee());
		pstmt.setInt(5, registLevel.getRegistQuota());
		int i = pstmt.executeUpdate();
		DBConnection.closeAll(null, pstmt, connection);
		return i;
	}

	@Override
	public int update(RegistLevel registLevel) throws Exception {
		String sql = " update registlevel set registcode=?,registname=?,sequenceno=?,registfee=?,registquota=?  where registlevelid = ?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, registLevel.getRegistCode());
		pstmt.setString(2, registLevel.getRegistName());
		pstmt.setInt(3, registLevel.getSequenceNo());
		pstmt.setDouble(4, registLevel.getRegistFee());
		pstmt.setInt(5, registLevel.getRegistQuota());
		pstmt.setInt(6, registLevel.getRegistLevelId());
		int i = pstmt.executeUpdate();
		DBConnection.closeAll(null, pstmt, connection);
		return i;
	}
}
