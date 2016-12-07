package vn.ds.news.domain;

public class User {

	private String username;
	private String hashedPassword;

	public User() {
		super();
	}

	public User(String username, String hashedPassword) {
		super();
		this.username = username;
		this.hashedPassword = hashedPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
}