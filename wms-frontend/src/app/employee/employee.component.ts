import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Employee } from './employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  private employees: Employee[];

  constructor(private empService: EmployeeService) { }

  ngOnInit() {
    this.empService.getEmployees().subscribe(employees => {
      this.employees = employees;
    })
  }
}
