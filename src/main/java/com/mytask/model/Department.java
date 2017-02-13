package com.mytask.model;

public class Department {
	private String description;
	private String uid;
	private String name;
	private String shortName;
	private String parentUID;
	private String parentType;
	private String chiefman;


	public Department(String description, String uid, String name,
			String shortName, String parentUID, String parentType) {
		super();
		this.description = description;
		this.uid = uid;
		this.name = name;
		this.shortName = shortName;
		this.parentUID = parentUID;
		this.parentType = parentType;
		this.chiefman="";
	}
	public Department(String description, String uid, String name) {
		super();
		this.description = description;
		this.uid = uid;
		this.name = name;
		this.shortName = "";
		this.parentUID = "";
		this.parentType = "";
		this.chiefman="";
	}
	public Department(String description, String uid, String name, String parent) {
		super();
		this.description = description;
		this.uid = uid;
		this.name = name;
		this.shortName = "";
		this.parentUID = parent;
		this.parentType = "";
		this.chiefman="";
	}
	
	public Department() {
		super();
		this.description = "";
		this.uid = "";
		this.name = "";
		this.shortName = "";
		this.parentUID = "";
		this.parentType = "";
		this.chiefman="";
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
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getParentUID() {
		return parentUID;
	}
	public void setParentUID(String parentUID) {
		this.parentUID = parentUID;
	}
	public String getParentType() {
		return parentType;
	}
	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	public String getChiefman() {
		return chiefman;
	}
	public void setChiefman(String chiefman) {
		this.chiefman = chiefman;
	}
	@Override
	public String toString() {
		return "Department [description=" + description + ", uid=" + uid
				+ ", name=" + name + ", shortName=" + shortName
				+ ", parentUID=" + parentUID + ", parentType=" + parentType
				+ ", chiefman=" + chiefman + "]";
	}

	
	


}
