package vn.ds.news.config;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

public class Authorizer implements SecurityContext {

	private JWTPrincipal principal;
	private boolean isSecure;

	public Authorizer(JWTPrincipal principal, boolean isSecure) {
		this.principal = principal;
		this.isSecure = isSecure;
	}

	@Override
	public Principal getUserPrincipal() {
		return principal;
	}

	@Override
	public boolean isUserInRole(String role) {
		return true;
	}

	@Override
	public boolean isSecure() {
		return isSecure;
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.DIGEST_AUTH;
	}
}
