package com.bl.demo.controller;
import com.bl.demo.model.Employee;
import com.bl.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    public IEmployeeService employeeService;

    @PostMapping("/login/id")
    public Employee display(@RequestBody Employee employee){
            return employeeService.loginProcess(employee);
    }

    @PostMapping("/register")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
}
