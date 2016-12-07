package vn.ds.news.domain;

public class AuthToken {
	private String token;
	private Integer expired;

	public AuthToken() {
		super();
	}

	public AuthToken(String token, Integer expired) {
		super();
		this.token = token;
		this.expired = expired;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getExpired() {
		return expired;
	}

	public void setExpired(Integer expired) {
		this.expired = expired;
	}
}