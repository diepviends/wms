package vn.ds.news.config;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import vn.ds.news.config.annotation.Authenticated;
import vn.ds.news.dao.AuthDao;

//@Provider
@Priority(Priorities.AUTHENTICATION)
@Authenticated
public class SecurityFilter implements ContainerRequestFilter {
	final static Logger logger = Logger.getLogger(SecurityFilter.class);

	@Autowired
	AuthDao userDao;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		String path = requestContext.getUriInfo().getPath();
		String method = requestContext.getMethod();
		String token = parseBearerToken(authorizationHeader);
		if (token != null) {
			try {
				JWTPrincipal principal = Tokenizer.parse(token);
				if (!userDao.isGranted(principal.getName(), path, method)) {
					logger.debug("Access Denied");
					throw new WebApplicationException("Access Denied", Status.FORBIDDEN);
				}
				Authorizer authorizer = new Authorizer(principal, requestContext.getSecurityContext().isSecure());
				requestContext.setSecurityContext(authorizer);
			} catch (ExpiredJwtException ex) {
				logger.debug(ex);
				throw new WebApplicationException("Token is expired", Status.UNAUTHORIZED);
			} catch (MalformedJwtException | SignatureException | IllegalArgumentException ex) {
				logger.debug(ex);
				throw new WebApplicationException("Token is invalid", Status.UNAUTHORIZED);
			}
		} else {
			throw new WebApplicationException("No Authorization header was found", Status.UNAUTHORIZED);
		}
	}

	private String parseBearerToken(final String bearerToken) {
		if (bearerToken == null)
			return null;
		Pattern tokenPattern = Pattern.compile("^Bearer$", Pattern.CASE_INSENSITIVE);
		String tokenValue = null;
		if (bearerToken != null) {
			String[] parts = bearerToken.split(" ");
			if (parts.length == 2) {
				String scheme = parts[0];
				String credentials = parts[1];
				if (tokenPattern.matcher(scheme).matches()) {
					tokenValue = credentials;
				}
			}
		}
		return tokenValue;
	}
}
