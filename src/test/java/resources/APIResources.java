package resources;

public enum APIResources {

	AppLoginAPI("webapp/patientAppV1/login"),
	DashboardAPI("webapp/patientAppV1/dashboard"),
	AboutUsAPI("webapp/patientAppV1/aboutus"),
	SurveyAnswers("webapp/patientAppV1/answerSurvey"),
	DayView("webapp/patientAppV1/day"),
	EventView("webapp/patientAppV1/eventView"),
	ForgotPassword("webapp/patientAppV1/forgotPassword"),
	HomeScreen("webapp/patientAppV1/callmeoffice"),
	MonthView("webapp/patientAppV1/month"),
	SignUp("webapp/patientAppV1/signup"),
	ChangePassword("webapp/patientAppV1/changepwd"),
	EditProfile("webapp/patientAppV1/aboutus"),
	ZoomCall("webapp/familyappframeV2/zoomvideocall");

	private String resources;

	APIResources(String resources){
		this.resources = resources;
	}

	public String getResources() {
		return resources;
	}

}
