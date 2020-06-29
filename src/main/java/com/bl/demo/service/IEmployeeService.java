package com.bl.demo.service;
import com.bl.demo.model.Employee;
import com.bl.demo.model.Login;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    Employee loginProcess(Login login);
}
