package com.FifthSpringBoot.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	private int EID;
	@Column(name="Employee_Name")
	private String Ename;
	@Column(name="Employee_Salary")
	private double Salary;
	
	
	
	
	public Employee() {
		super();
	}
	public Employee(int eID, String ename, double salary) {
		super();
		EID = eID;
		Ename = ename;
		Salary = salary;
	}
	
	
	
	public int getEID() {
		return EID;
	}
	public void setEID(int eID) {
		EID = eID;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [EID=" + EID + ", Ename=" + Ename + ", Salary=" + Salary + "]";
	}
	
	
}
