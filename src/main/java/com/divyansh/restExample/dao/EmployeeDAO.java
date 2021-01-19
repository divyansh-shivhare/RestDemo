package com.divyansh.restExample.dao;



import java.util.List;

import com.divyansh.restExample.model.Employee;


public interface EmployeeDAO {



    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);
}
