package vn.ds.news.dao;

public interface AuthDao {
	public boolean isUserValid(String username, String password);

	public boolean isGranted(String username, String path, String method);
}
