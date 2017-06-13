package vn.ds.pfm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.ds.pfm.domain.aggregate.customer.Customer;
import vn.ds.pfm.domain.aggregate.customer.CustomerRepository;
import vn.ds.pfm.domain.aggregate.employee.Employee;
import vn.ds.pfm.domain.aggregate.employee.EmployeeRepository;
import vn.ds.pfm.domain.aggregate.product.Product;
import vn.ds.pfm.domain.aggregate.product.ProductRepository;
import vn.ds.pfm.domain.aggregate.supplier.Supplier;
import vn.ds.pfm.domain.aggregate.supplier.SupplierRepository;

@RestController
public class TestController {

	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private CustomerRepository cusRepo;
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private SupplierRepository supRepo;

	@RequestMapping(value = "initmaster", method = RequestMethod.GET)
	public void InitMaster() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("John"));
		customers.add(new Customer("Mark"));
		customers.add(new Customer("Peter"));
		customers.add(new Customer("Linda"));
		customers.add(new Customer("Pert"));
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Anna", "anna"));
		employees.add(new Employee("Beth", "beth"));
		employees.add(new Employee("Admin", "admin"));
		List<Product> products = new ArrayList<>();
		products.add(new Product("PI01", "KG", 100d));
		products.add(new Product("PI02", "KG", 120d));
		products.add(new Product("PI03", "KG", 130d));
		products.add(new Product("PI04", "KG", 200d));
		products.add(new Product("PI05", "KG", 400d));
		products.add(new Product("PI06", "KG", 450d));
		products.add(new Product("PI07", "KG", 505d));
		List<Supplier> suplliers = new ArrayList<>();
		suplliers.add(new Supplier("Toto", "123 Tokana street, Tokyo"));
		prodRepo.save(products);
		cusRepo.save(customers);
		empRepo.save(employees);
		supRepo.save(suplliers);

	}
}
