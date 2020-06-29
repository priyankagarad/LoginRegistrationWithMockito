package com.bl.demo.service;
import com.bl.demo.model.Employee;
import com.bl.demo.model.Login;
import com.bl.demo.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    IEmployeeRepository employeeRepository;

    public String greeting(){
        return "Welcome";
    }

    /**+
     * @param employee :Reference of Employee Model Class
     * @return
     */
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * @Purpose: check the Username and password are Match or not in the database
     * @param login :Reference of Employee Model Class
     * @return
     */
    @Override
    public Employee loginProcess(Login login) {
        List<Employee> list = employeeRepository.findAll();
        Optional<Employee> employee1 = list.stream()
                .filter(e -> e.getName().equals(login.getName()) && e.getPassword().equals(login.getPassword()))
                .findAny();
        return employee1.get() != null ? employee1.get() : null;
    }
}
