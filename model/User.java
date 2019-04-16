package model;


public class User {
 
	private int user_id;
	private String email;
	private String password;
	private String fullname;
	
	public User() {
		
	}

	public User(int user_id, String email, String password, String fullname) {

		this.user_id = user_id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", password=" + password + ", fullname=" + fullname
				+ "]";
	}
	
	
}
