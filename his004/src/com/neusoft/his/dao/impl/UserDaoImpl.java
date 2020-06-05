package com.neusoft.his.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.his.dao.UserDao;
import com.neusoft.his.entity.User;
import com.neusoft.his.util.DBConnection;

public class UserDaoImpl implements UserDao {
	
	private static UserDaoImpl dao  = new UserDaoImpl();
	
	private UserDaoImpl() {
		
	}
	
	public static UserDaoImpl getUserDaoImpl() {
		
		return dao;
	}
	

	@Override
	public User findUserByUnamePwd(String username, String password) throws Exception {
		String sql = "select * from user where delMark = 1 and  username = ? and password =? ";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		User user = null;
		if(rs.next()) {
			user = new User();
			user.setUserId(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setDelMark(rs.getInt("delMark"));
			user.setDepartmentId(rs.getInt("departmentid"));
			user.setDocTitleId(rs.getInt("doctitleid"));
			user.setIsScheduling(rs.getInt("isscheduling"));
			user.setRealname(rs.getString("realname"));
			user.setUserType(rs.getInt("usertype"));
			user.setRegistLevelId(rs.getInt("registlevelid"));
		}
		
		
		DBConnection.closeAll(rs, pstmt, connection);
		return user;
	}

	@Override
	public List<User> findUsers(int beginIndex, int pageSize) throws Exception {
		List<User> list = new ArrayList<User>();
		StringBuffer sub = new StringBuffer();
		sub.append("select u.*, ");
		sub.append(" (select deptname from department d where d.departmentid = u.departmentid) deptname,");
		sub.append(" (select constantname from constantitem i where i.constrantitemid = u.userType) usertypename,");
		sub.append(" (select constantname from  constantitem i where i.constrantitemid = u.docTitleId ) doctitlename,");
		sub.append(" (select registname from registlevel r where r.registlevelid = u.registlevelid)registlevelname");
		sub.append(" from user u");
		sub.append(" where delmark = 1");
		sub.append(" limit ?,?");
//		String sql = "select * from user where delmark = 1 limit ?,?";
		String sql = sub.toString();
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, beginIndex);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setDelMark(rs.getInt("delMark"));
			user.setDepartmentId(rs.getInt("departmentid"));
			user.setDocTitleId(rs.getInt("doctitleid"));
			user.setIsScheduling(rs.getInt("isscheduling"));
			user.setRealname(rs.getString("realname"));
			user.setUserType(rs.getInt("usertype"));
			user.setRegistLevelId(rs.getInt("registlevelid"));
			user.setUserTypeName(rs.getString("usertypename"));
			user.setDocTitleName(rs.getString("docTitleName"));
			user.setRegistLevelName(rs.getString("registLevelName"));
			user.setDeptname(rs.getString("deptname"));
			list.add(user);
		}
		
		
		DBConnection.closeAll(rs, pstmt, connection);
		
		return list;
	}

	@Override
	public int getTotalCount() throws Exception {
		String sql = "select count(*) from user where delmark = 1";
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int i = rs.getInt(1);
		DBConnection.closeAll(null, pstmt, connection);
		return i;
	}

}
