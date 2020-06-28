package com.bl.demo;
import com.bl.demo.controller.EmployeeController;
import com.bl.demo.model.Employee;
import com.bl.demo.service.IEmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebMvcTest (EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IEmployeeService employeeService;

    @Test
    public void givenApi_WhenMap_shouldReturnGreetingMessage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Welcome"));
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @Test
    public void givenApi_WhenUserNameAndPasswordAreCorrect_ShouldReturnEmployee() throws Exception {
        Employee employee = new Employee("priyanka", "123");
        String inputJson = this.mapToJson(employee);
        given(employeeService.addEmployee(employee)).willReturn(new Employee());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
                .accept(MediaType.APPLICATION_JSON).content(inputJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = this.mockMvc.perform(requestBuilder)
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        Assert.assertEquals(contentAsString, inputJson);
    }

    @Test
    public void givenEmployee_WhenInformationPassed_ShouldReturnEmployee() throws Exception {
        Employee employee = new Employee(1, "priya", "P@gmail.com", "123");
        String employeeJson = this.mapToJson(employee);
        given(employeeService.addEmployee(any(Employee.class))).willReturn(employee);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
                .accept(MediaType.APPLICATION_JSON).content(employeeJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = this.mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseInJson = response.getContentAsString();
        Assert.assertEquals(responseInJson, employeeJson);
    }
}
