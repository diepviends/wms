package vn.ds.news.domain;

public class Product {
	public Product(String c, String n, Integer q, Integer cat) {
		code = c;
		name = n;
		qty = q;
		category = cat;
	}

	public String code;
	public String name;
	public Integer qty;
	public Integer category;
}
