package com.FifthSpringBoot.ControllerTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.FifthSpringBoot.Controller.MyController;
import com.FifthSpringBoot.Entity.Employee;
import com.FifthSpringBoot.Entity_Interface.Employee_interface;
import com.FifthSpringBoot.Interface_Impl.Employee_interface_Impl;
import com.FifthSpringBoot.ServiceTest.ServiceLayerTes;

@SpringBootTest(classes= {ServiceLayerTes.class})
public class ControllerTest1 {
	
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
	public void testAddEmployee() {
		Employee b=new Employee(101,"Soul",10000);
		when(emp.AddEmployee(b)).thenReturn(b);
		assertEquals(b,temp.AddEmployee(b));
	}
	
	
	
}
