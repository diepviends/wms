package vn.ds.news.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.glassfish.jersey.servlet.ServletProperties;

import vn.ds.news.api.Index;

public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {

		packages(true, "vn.ds.news");

		register(RequestContextFilter.class);
		register(JacksonFeature.class);
		register(JspMvcFeature.class);
		register(Index.class);

		property(ServletProperties.FILTER_STATIC_CONTENT_REGEX, "/static/.*");
		property(JspMvcFeature.TEMPLATE_BASE_PATH, "/");
	}
}
