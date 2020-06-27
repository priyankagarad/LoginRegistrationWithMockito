package com.bl.demo;
import com.bl.demo.controller.EmployeeController;
import com.bl.demo.service.IEmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(EmployeeController.class)
public class ServiceMockitoTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IEmployeeService employeeService;

    @Test
    public void GivenWrongLoginDetail_ShouldReturnErrorOnPage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/login").
                accept(MediaType.ALL);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(404, mvcResult.getResponse().getStatus());
    }
}
