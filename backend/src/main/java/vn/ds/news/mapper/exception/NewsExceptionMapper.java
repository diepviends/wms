
package vn.ds.news.mapper.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

//@Provider
public class NewsExceptionMapper implements ExceptionMapper<WebApplicationException> {
	final static Logger logger = Logger.getLogger(NewsExceptionMapper.class);

	@Override
	public Response toResponse(WebApplicationException ex) {
		return Response.status(ex.getResponse().getStatus()).type(MediaType.APPLICATION_JSON)
				.entity(new Error(ex.getMessage())).build();
	}

	class Error {
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Error(String message) {
			super();
			this.message = message;
		}
	}
}