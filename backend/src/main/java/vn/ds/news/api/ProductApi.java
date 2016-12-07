package vn.ds.news.api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vn.ds.news.dao.ProductRepo;
import vn.ds.news.domain.Product;

@Path("products")
public class ProductApi {

	@POST
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response search(ProductCondition condition) {
		List<Product> lst = ProductRepo.search(condition);
		return Response.ok().entity(lst)
				.header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
				.build();
	}

	@DELETE
	@Path("{code}")
	public Response delete(@PathParam("code") String code) {
		ProductRepo.delete(code);
		return Response.noContent().build();
	}
}
