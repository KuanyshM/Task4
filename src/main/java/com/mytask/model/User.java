package com.mytask.model;

public class User {
	private String description;
	private String uid;
	private String name;
	private String postUID;
	private String departmentUID;
	private String departmentType;
	public User(String description, String uid, String name, String postUID,
			String departmentUID, String departmentType) {
		super();
		this.description = description;
		this.uid = uid;
		this.name = name;
		this.postUID = postUID;
		this.departmentUID = departmentUID;
		this.departmentType = departmentType;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostUID() {
		return postUID;
	}
	public void setPostUID(String postUID) {
		this.postUID = postUID;
	}
	public String getDepartmentUID() {
		return departmentUID;
	}
	public void setDepartmentUID(String departmentUID) {
		this.departmentUID = departmentUID;
	}
	public String getDepartmentType() {
		return departmentType;
	}
	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}
	@Override
	public String toString() {
		return "User [description=" + description + ", uid=" + uid + ", name="
				+ name + ", postUID=" + postUID + ", departmentUID="
				+ departmentUID + ", departmentType=" + departmentType + "]";
	}
	
	
	

}
