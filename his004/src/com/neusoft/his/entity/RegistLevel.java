package com.neusoft.his.entity;

public class RegistLevel {

	private int registLevelId;
	
	private String registCode; 
	
	private String registName;
	
	private int SequenceNo;
	
	private  double registFee;
	
	private int registQuota;
	
	private int delMark;

	public int getRegistLevelId() {
		return registLevelId;
	}

	public void setRegistLevelId(int registLevelId) {
		this.registLevelId = registLevelId;
	}

	public String getRegistCode() {
		return registCode;
	}

	public void setRegistCode(String registCode) {
		this.registCode = registCode;
	}

	public String getRegistName() {
		return registName;
	}

	public void setRegistName(String registName) {
		this.registName = registName;
	}

	public int getSequenceNo() {
		return SequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		SequenceNo = sequenceNo;
	}

	public double getRegistFee() {
		return registFee;
	}

	public void setRegistFee(double registFee) {
		this.registFee = registFee;
	}

	public int getRegistQuota() {
		return registQuota;
	}

	public void setRegistQuota(int registQuota) {
		this.registQuota = registQuota;
	}

	public int getDelMark() {
		return delMark;
	}

	public void setDelMark(int delMark) {
		this.delMark = delMark;
	}
	
}
