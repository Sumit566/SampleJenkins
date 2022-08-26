package com.FifthSpringBoot.ServiceTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.FifthSpringBoot.ControllerTest.ControllerTest1;
import com.FifthSpringBoot.Dao.Employee_Dao;
import com.FifthSpringBoot.Entity.Employee;
import com.FifthSpringBoot.Interface_Impl.Employee_interface_Impl;

@SpringBootTest(classes= {ControllerTest1.class})
public class ServiceLayerTes {
	@Mock
	Employee_Dao employeeDao;
	@InjectMocks
	Employee_interface_Impl temp;
	@Test
	public void testgetAllEmployeeList() {
		
		List<Employee> a=new ArrayList<>();
		a.add(new Employee(101,"Soul",2000));
		
		when(employeeDao.findAll()).thenReturn(a);
		assertEquals(temp.getAllEmployee().size(),1);
	}
	
	@Test
	public void testAddEmployee() {
		Employee a=new Employee(101,"Soul",20000);
		when(employeeDao.save(a)).thenReturn(a);
		assertEquals(temp.AddEmployee(a),a);
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
		assertTrue(b.getSalary()==temp.UpdateEmployeeSalary(eid, salary).getSalary());
		
	}

}
