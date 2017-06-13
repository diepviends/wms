package vn.ds.pfm.employee.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.ds.pfm.domain.aggregate.employee.Employee;
import vn.ds.pfm.domain.aggregate.employee.EmployeeRepository;

@RestController
@RequestMapping("employees")
public class EmployeeApi {
	@Autowired
	private EmployeeRepository empRepo;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeDto> getAll() {
		List<Employee> employees = empRepo.findAll();
		return employees.stream().map(emp -> new EmployeeDto(emp.getEmpName(), emp.getPassword()))
				.collect(Collectors.toList());
	}
}
