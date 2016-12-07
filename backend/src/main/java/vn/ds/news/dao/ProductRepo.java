package vn.ds.news.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vn.ds.news.api.ProductCondition;
import vn.ds.news.domain.Category;
import vn.ds.news.domain.Product;

public class ProductRepo {
	private static List<Product> products;
	static {
		products = new ArrayList<>();
		products.add(new Product("TX1", "Jersey", 10, 1));
		products.add(new Product("DX2", "Java", 100, 1));
		products.add(new Product("BCE", "John", 123, 2));
		products.add(new Product("EFB", "Trump", 111, 2));
		products.add(new Product("DAC", "Dainamax", 100, 1));
		products.add(new Product("TSD", "React", 200, 1));
		products.add(new Product("YHC", "Diepviends", 300, 2));
		products.add(new Product("EWC", "Java Programming", 400, 1));
		products.add(new Product("BND", "Komtum", 400, 2));
	}

	public static List<Category> findAllCategories() {
		List<Category> lst = new ArrayList<>();
		lst.add(new Category(1, "Programing"));
		lst.add(new Category(2, "Person"));
		return lst;
	}

	public static List<Product> search(ProductCondition condition) {
		List<Product> lst = new ArrayList<>();
		if (products.isEmpty())
			return lst;
		for (Product p : products) {
			if (p.name.toLowerCase().contains(condition.getName().toLowerCase())
					&& matchCat(p.category, condition.getCategory()))
				lst.add(p);

		}
		return lst;
	}

	private static boolean matchCat(int c1, int c2) {
		return (c1 == c2 || c2 == 0) ? true : false;
	}

	public static void delete(String code) {
		Iterator<Product> it = products.iterator();
		while (it.hasNext()) {
			Product p = it.next();
			if (p.code.equalsIgnoreCase(code))
				it.remove();
		}
	}
}
