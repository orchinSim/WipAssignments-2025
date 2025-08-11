package com.wip.model;

public class Dept {
	private int deptId;
	private String deptName;
    private String email;
    private String location;

	public Dept(int deptId, String deptName, String email, String location) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.email = email;
		this.location = location;
	}
	
    public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", email=" + email + ", location=" + location
				+ "]";
	}
	
}
