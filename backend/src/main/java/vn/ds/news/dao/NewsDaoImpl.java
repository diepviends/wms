package vn.ds.news.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import vn.ds.news.domain.News;

@Component
public class NewsDaoImpl implements NewsDao {

	private static List<News> lst;
	static {
		lst = Arrays.asList(new News(100, "title", "content"));
	}

	@Override
	public List<News> findAll() {
		return lst;
	}

	@Override
	public void create(News news) {
		// TODO Auto-generated method stub

	}

}
