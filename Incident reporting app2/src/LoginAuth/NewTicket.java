package LoginAuth;

public class NewTicket {
	int type;
	String  details, campus, location;
	//String date, reportedby,comments , authorities	,attachments;
	//Enum action , status;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
/*	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReportedby() {
		return reportedby;
	}
	public void setReportedby(String reportedby) {
		this.reportedby = reportedby;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public Enum getAction() {
		return action;
	}
	public void setAction(Enum action) {
		this.action = action;
	}
	public Enum getStatus() {
		return status;
	}
	public void setStatus(Enum status) {
		this.status = status;
	}*/
	public NewTicket(int type, String details, String campus, String location) {
		super();
		this.type = type;
		this.details = details;
		this.campus = campus;
		this.location = location;
	}
	
	
	

}
