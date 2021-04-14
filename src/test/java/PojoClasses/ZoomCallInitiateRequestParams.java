package PojoClasses;

public class ZoomCallInitiateRequestParams {
	private String 	patient_id;
	private String calltype;

	
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	public String getCalltype() {
		return calltype;
	}
	public void setCalltype(String calltype) {
		this.calltype = calltype;
	}
}
