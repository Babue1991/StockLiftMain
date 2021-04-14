package PojoClasses;

public class loginResponseParams {
	private String status;
	private String message;
	private String token;
	private String account_logo;
	private String server;
	private String is_first_login;
	private String user_id;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAccount_logo() {
		return account_logo;
	}
	public void setAccount_logo(String account_logo) {
		this.account_logo = account_logo;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getIs_first_login() {
		return is_first_login;
	}
	public void setIs_first_login(String is_first_login) {
		this.is_first_login = is_first_login;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}	
		
}
