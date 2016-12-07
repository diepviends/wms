package vn.ds.news.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;

import vn.ds.news.config.Tokenizer;
import vn.ds.news.config.annotation.Authenticated;
import vn.ds.news.dao.AuthDao;
import vn.ds.news.domain.AuthToken;

@Path("auth")
public class AuthApi {

	final static Logger logger = Logger.getLogger(AuthApi.class);

	@Inject
	AuthDao userDao;

	@Inject
	SecurityContext securityContext;

	@POST
	@Path("authenticate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticate(@HeaderParam("username") String username, @HeaderParam("password") String password) {
		if (userDao.isUserValid(username, password)) {
			String token = Tokenizer.generate(username);
			return Response.ok(new AuthToken(token, Tokenizer.EXPIRED)).build();
		} else {
			throw new WebApplicationException("Username or password invalid", Status.BAD_REQUEST);
		}

	}

	@GET
	@Path("user")
	@Authenticated
	public Response getUser() {
		return Response.ok("user api").build();
	}

	@GET
	@Path("admin")
	@Authenticated
	public Response getAdmin() {
		return Response.ok("admin api").build();
	}
}
