package PojoClasses;

import java.util.List;

public class CallDetailEntryRequestParams {

	private String meeting_id;
	private List<String> issues;
	private String notes;
	
	public String getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(String meeting_id) {
		this.meeting_id = meeting_id;
	}
	public List<String> getIssues() {
		return issues;
	}
	public void setIssues(List<String> issues) {
		this.issues = issues;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
