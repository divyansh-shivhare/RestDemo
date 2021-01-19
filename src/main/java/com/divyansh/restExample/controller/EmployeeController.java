package com.divyansh.restExample.controller;



@RestController
@RequestMapping("/api")
public class EmployeeController {



    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null)
        {
            throw new RuntimeException("Employee Id not found - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null)
        {
            throw new RuntimeException("Employee Id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee id - " + employeeId;
    }
}
