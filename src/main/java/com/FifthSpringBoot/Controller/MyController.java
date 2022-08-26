package com.FifthSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FifthSpringBoot.Entity.Employee;
import com.FifthSpringBoot.Entity_Interface.Employee_interface;

@RestController
public class MyController {
	@Autowired
	private Employee_interface emp;
	
	@GetMapping("/Employees_Registered")
	public List<Employee> getEmployees(){
		return this.emp.getAllEmployee();
	}
	@PutMapping(value="Employees_Registered/{EID}/{Salary}")
	public Employee updateEmployee(@PathVariable("EID") Integer EID,@PathVariable("Salary") Double Salary) {
		return this.emp.UpdateEmployeeSalary(EID,Salary);
	}
	@PostMapping("/Employees_Registered")
	public Employee AddEmployee(@RequestBody Employee emp) {
		return this.emp.AddEmployee(emp);
	}
}
