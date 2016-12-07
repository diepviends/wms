package vn.ds.news.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AuthDaoImpl implements AuthDao {
	private Logger logger = Logger.getLogger(AuthDaoImpl.class);

	@Override
	public boolean isUserValid(String username, String password) {
		return "admin".equals(username) || "diepviends".equals(username);
	}

	@Override
	public boolean isGranted(String username, String path, String method) {
		logger.debug(String.format("grant user: {%s}, path: {%s}, method: {%s}", username, path, method));
		if ("admin".equals(username) && path.startsWith("auth/admin"))
			return true;
		if ("diepviends".equals(username) && path.startsWith("auth/user"))
			return true;
		return false;
	}
}
