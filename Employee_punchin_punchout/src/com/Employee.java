package com;

import java.util.List;

public class Employee {
	
	
	
private	String Fname;
private	String Lname;
public	String  emailId;
public	String passwd;
private	List<EmployeeAtt> attend;
	
	public List<EmployeeAtt> getAttend() {
	return attend;
}
public void setAttend(List<EmployeeAtt> attend) {
	this.attend = attend;
}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	public Employee(String fname, String lname, String emailId, String passwd) {
		
		Fname = fname;
		Lname = lname;
		this.emailId = emailId;
		this.passwd = passwd;
	}
	public Employee() {
		
	}
	

}
