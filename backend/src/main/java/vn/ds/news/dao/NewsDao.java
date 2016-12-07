package vn.ds.news.dao;

import java.util.List;

import vn.ds.news.domain.News;

public interface NewsDao {
	public List<News> findAll();

	public void create(News news);
}
