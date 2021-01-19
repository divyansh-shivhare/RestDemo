package com.divyansh.restExample.service;



import com.divyansh.restExample.model.Employee;
import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);

}
