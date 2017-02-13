package com.mytask.model;

public class Models {
	
private Object oObject;
private Object BranchObject;


public Models(Object oObject, Object branchObject) {
	super();
	this.oObject = oObject;
	BranchObject = branchObject;
}
public Object getoObject() {
	return oObject;
}
public void setoObject(Object oObject) {
	this.oObject = oObject;
}
public Object getBranchObject() {
	return BranchObject;
}
public void setBranchObject(Object branchObject) {
	BranchObject = branchObject;
}
@Override
public String toString() {
	return "Models [oObject=" + oObject + ", BranchObject=" + BranchObject
			+ "]";
}



	

}
