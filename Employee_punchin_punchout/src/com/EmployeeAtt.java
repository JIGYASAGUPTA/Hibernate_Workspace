package com;

import java.util.Date;

public class EmployeeAtt {
  String emailid ;
  Date date;
  boolean punchin;
  boolean punchout;
  
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public boolean isPunchin() {
	return punchin;
}
public void setPunchin(boolean punchin) {
	this.punchin = punchin;
}
public boolean isPunchout() {
	return punchout;
}
public void setPunchout(boolean punchout) {
	this.punchout = punchout;
}
public EmployeeAtt(String emailid, Date date, boolean punchin, boolean punchout) {
	super();
	this.emailid = emailid;
	this.date = date;
	this.punchin = punchin;
	this.punchout = punchout;
}
public EmployeeAtt() {
	super();
}
  

	
	
	
	

}
