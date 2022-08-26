package com.FifthSpringBoot.Interface_Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FifthSpringBoot.Dao.Employee_Dao;
import com.FifthSpringBoot.Entity.Employee;
import com.FifthSpringBoot.Entity_Interface.Employee_interface;
@Service
public class Employee_interface_Impl implements Employee_interface {
	@Autowired
	Employee_Dao employeeDao;

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> temp=employeeDao.findAll();
		return temp;
	}

	@Override
	public Employee UpdateEmployeeSalary(int EID, double Salary) {
		List<Employee> temp=employeeDao.findAll();
		for(Employee e:temp) {
			if(e.getEID()==EID) {
				e.setSalary(Salary);
				employeeDao.save(e);
				return e;
			}
		}
		return null;
	}

	@Override
	public Employee AddEmployee(Employee emp) {
		return employeeDao.save(emp);
	}
	
}
