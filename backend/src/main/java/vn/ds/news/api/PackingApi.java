package vn.ds.news.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import vn.ds.news.dao.PackingRepository;
import vn.ds.news.domain.entity.PackingInstance;
import vn.ds.news.domain.entity.PackingInstanceId;
import vn.ds.news.domain.entity.PackingInstancePath;
import vn.ds.news.domain.entity.PackingInstancePathId;

@Path("packing")
public class PackingApi {

	@Autowired
	PackingRepository repo;

	@POST
	public Response create(Form form) {
		repo.save(convert(form));
		return Response.noContent().build();
	}

	private PackingInstance convert(Form form) {
		PackingInstanceId id = new PackingInstanceId(form.customer, form.product, form.serial, form.status);
		PackingInstance p = new PackingInstance(id, form.sub, form.qty);
		List<PackingInstancePath> children = new ArrayList<>();
		for (Packing child : form.children) {
			children.add(convertPath(form.serial, child.serial));
		}
		return p;
	}

	private PackingInstancePath convertPath(String p, String c) {
		PackingInstancePathId id = new PackingInstancePathId(p, c);
		PackingInstancePath path = new PackingInstancePath(id);
		return path;
	}
}

class Packing {
	public String customer;
	public String product;
	public String serial;
	public String status;
	public String sub;
	public Double qty;
}

class Form extends Packing {
	public List<Packing> children;
}
