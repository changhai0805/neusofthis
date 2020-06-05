package com.neusoft.his.entity;

public class Department {

	private int departmentId;
	
	private String deptCode;
	
	private String deptName;
	
	private int deptCategoryId;// 科室分类  （内科，外科。。) constantitemid
	
	private int deptType;//科室职能(行政 财务  临床 医技)constantitemid
	
	private int delMark;
	
	private String deptCategoryName;
	
	private String deptTypeName;
	
	
	
	public int getDeptCategoryId() {
		return deptCategoryId;
	}

	public void setDeptCategoryId(int deptCategoryId) {
		this.deptCategoryId = deptCategoryId;
	}

	public int getDeptType() {
		return deptType;
	}

	public void setDeptType(int deptType) {
		this.deptType = deptType;
	}

	public int getDelMark() {
		return delMark;
	}

	public void setDelMark(int delMark) {
		this.delMark = delMark;
	}

	public String getDeptCategoryName() {
		return deptCategoryName;
	}

	public void setDeptCategoryName(String deptCategoryName) {
		this.deptCategoryName = deptCategoryName;
	}

	public String getDeptTypeName() {
		return deptTypeName;
	}

	public void setDeptTypeName(String deptTypeName) {
		this.deptTypeName = deptTypeName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
	
}
