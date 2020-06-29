/*********************************************************************************************************************
 * @purpose: In EmployeeController Class Two api Created for login and registration.
 * @Author: Priyanka
 * @Date: 27/6/2020
 *********************************************************************************************************************/
package com.bl.demo.controller;
import com.bl.demo.model.Employee;
import com.bl.demo.model.Login;
import com.bl.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    public IEmployeeService employeeService;

    @GetMapping("/")
    public String greeting(){
        return "Welcome";
    }

    @PostMapping("/login")
    public Employee display(@RequestBody Login login){
        return employeeService.loginProcess(login);
    }

    @PostMapping("/register")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
}
