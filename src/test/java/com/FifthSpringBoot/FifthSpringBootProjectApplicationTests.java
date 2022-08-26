package com.FifthSpringBoot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.FifthSpringBoot.Controller.MyController;
import com.FifthSpringBoot.Dao.Employee_Dao;
import com.FifthSpringBoot.Entity.Employee;
import com.FifthSpringBoot.Interface_Impl.Employee_interface_Impl;

@SpringBootTest
class FifthSpringBootProjectApplicationTests {
	@Mock
	Employee_Dao employeeDao;
	@InjectMocks
	Employee_interface_Impl f;
	@Test
	public void testgetAllEmployeeList() {
		
		List<Employee> a=new ArrayList<>();
		a.add(new Employee(101,"Soul",2000));
		
		when(employeeDao.findAll()).thenReturn(a);
		assertEquals(f.getAllEmployee().size(),1);
	}
	
	@Test
	public void testAddEmployee() {
		Employee a=new Employee(101,"Soul",20000);
		when(employeeDao.save(a)).thenReturn(a);
		assertEquals(f.AddEmployee(a),a);
	}
	@Test
	public void testUpdateSalary() {
		List<Employee> a=new ArrayList<>();
		Employee b=new Employee(101,"Soul",10000);
		a.add(new Employee(101,"Soul",2000));
		a.add(new Employee(102,"Godlike",2000));
		int eid=101;
		int salary=10000;
		
		when(employeeDao.findAll()).thenReturn(a);
		assertTrue(b.getSalary()==f.UpdateEmployeeSalary(eid, salary).getSalary());
		
	}
	
	@Mock
	private Employee_interface_Impl emp;
	@InjectMocks
	private MyController temp;
	@Test
	public void testgetEmployees() {
		List<Employee> a=new ArrayList<>();
		a.add(new Employee(101,"Soul",2000));
		
		when(emp.getAllEmployee()).thenReturn(a);
		assertEquals(temp.getEmployees().size(),1);
	}
	@Test
	public void testupdateEmployee() {
		Employee b=new Employee(101,"Soul",10000);
		when(emp.UpdateEmployeeSalary(101,b.getSalary())).thenReturn(b);
		assertEquals(b.getSalary(),temp.updateEmployee(101, 10000D).getSalary());
	}
	@Test
	public void test1AddEmployee() {
		Employee b=new Employee(101,"Soul",10000);
		when(emp.AddEmployee(b)).thenReturn(b);
		assertEquals(b,temp.AddEmployee(b));
	}
	

}
