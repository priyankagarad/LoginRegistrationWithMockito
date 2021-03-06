package com.bl.demo;
import com.bl.demo.model.Employee;
import com.bl.demo.model.Login;
import com.bl.demo.repository.IEmployeeRepository;
import com.bl.demo.service.IEmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    List<Employee> employeeList = new ArrayList<>();

    @Mock
    IEmployeeRepository employeeRepository;

    @Autowired
    IEmployeeService employeeService;

    @Test
    public void givenEmployee_whenRegister_shouldAddDetail() {
        Employee employee = new Employee(1, "priya", "p@gmail.com", "123");
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee employee1 = employeeService.addEmployee(employee);
        Assert.assertEquals(employee1, employee);
    }

    @Test
    public void givenRegisterEmployee_whenLogin_shouldReturnLogin() {
        Employee employee = new Employee(1, "priya", "p@gmail.com", "123");
        Login login = new Login();
        login.setName("priya");
        login.setPassword("123");
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee employee1 = employeeService.loginProcess(login);
        Assert.assertEquals(employee1, employee);
    }
}