package com.bl.demo.service;
import com.bl.demo.model.Employee;
import com.bl.demo.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }
    
}
