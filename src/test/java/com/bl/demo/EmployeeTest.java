package com.bl.demo;
import com.bl.demo.model.Employee;
import com.bl.demo.repository.IEmployeeRepository;
import com.bl.demo.service.IEmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {

    @Mock
    IEmployeeRepository employeeRepository;

    @Autowired
    IEmployeeService employeeService;

    @Test
    void userRegister() {
        Employee employee=new Employee(1,"priya","p@gmail.com","123");
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee employee1=employeeService.addEmployee(employee);
        Assert.assertEquals(employee1,employee);
    }

    @Test
    void userLogin() {
        Employee employee=new Employee(1,"priya","p@gmail.com","123");
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee employee1=employeeService.loginProcess(employee);
        Assert.assertEquals(employee1,employee);
    }
}
