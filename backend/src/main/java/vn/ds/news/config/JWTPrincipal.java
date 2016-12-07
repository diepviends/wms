package vn.ds.news.config;

import java.security.Principal;

public class JWTPrincipal implements Principal {
	private String name;

	public JWTPrincipal(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}