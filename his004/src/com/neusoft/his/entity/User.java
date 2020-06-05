package com.neusoft.his.entity;

public class User {

	private int userId;
	
	private String username;
	
	private String password;
	
	private Department dept;
	
	private String realname;
	
	private int userType;
	
	private int docTitleId;
	
	private int isScheduling;
	
	private int departmentId;
	
	private int registLevelId;
	
	private int delMark;
	
	//扩充属性，便于查询结果的封装
	private String deptname;
	
	private String docTitleName;
	
	private String registLevelName;
	
	private String userTypeName;
	

	
	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDocTitleName() {
		return docTitleName;
	}

	public void setDocTitleName(String docTitleName) {
		this.docTitleName = docTitleName;
	}

	public String getRegistLevelName() {
		return registLevelName;
	}

	public void setRegistLevelName(String registLevelName) {
		this.registLevelName = registLevelName;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getDocTitleId() {
		return docTitleId;
	}

	public void setDocTitleId(int docTitleId) {
		this.docTitleId = docTitleId;
	}

	public int getIsScheduling() {
		return isScheduling;
	}

	public void setIsScheduling(int isScheduling) {
		this.isScheduling = isScheduling;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getRegistLevelId() {
		return registLevelId;
	}

	public void setRegistLevelId(int registLevelId) {
		this.registLevelId = registLevelId;
	}

	public int getDelMark() {
		return delMark;
	}

	public void setDelMark(int delMark) {
		this.delMark = delMark;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
