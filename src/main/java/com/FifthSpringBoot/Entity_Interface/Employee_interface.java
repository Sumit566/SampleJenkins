package com.FifthSpringBoot.Entity_Interface;

import java.util.List;

import com.FifthSpringBoot.Entity.Employee;

public interface Employee_interface {
	public List<Employee> getAllEmployee();
	public Employee UpdateEmployeeSalary(int EID,double Salary);
	public Employee AddEmployee(Employee emp);
}
