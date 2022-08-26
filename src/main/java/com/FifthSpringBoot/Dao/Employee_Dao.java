package com.FifthSpringBoot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FifthSpringBoot.Entity.Employee;


public interface Employee_Dao extends JpaRepository<Employee,Integer>{

}
