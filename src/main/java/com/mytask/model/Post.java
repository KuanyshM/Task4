package com.mytask.model;

public class Post {
	private String description;
	private String uid;
	private String name;
	private String department;
	
	
	public Post(String description, String uid, String name) {
		super();
		this.description = description;
		this.uid = uid;
		this.name = name;
		this.department="";
		
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Post [description=" + description + ", uid=" + uid + ", name="
				+ name + ", department=" + department + "]";
	}

	
	
	

}
