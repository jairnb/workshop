package com.workshop.employeeservice.controller;

import com.workshop.employeeservice.dto.EmployeeList;
import com.workshop.employeeservice.entity.Employee;
import com.workshop.employeeservice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
*I'm not quite sure if those are unit tests, but fuck it
* */

@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc
class EmployeeControllerUnitTest {

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeServiceMock;

    @Test
    public void shouldFindAllEmployees() throws Exception {

        String json = """
                {
                    "employees": [
                        {
                			"firstName": "John"
                		}
                    ]
                }
                """;


        var employeeList = new EmployeeList();
        var emp1 = new Employee();
        emp1.setFirstName("John");
        employeeList.setEmployees(List.of(emp1));

        Mockito.when(employeeServiceMock.findAll()).thenReturn(employeeList);

        ResultActions resultActions = mockMvc.perform(get("/api/v1/employee"))
                .andExpect(status().isOk())
                .andExpect(content().json(json));

        JSONAssert.assertEquals(json, resultActions.andReturn().getResponse().getContentAsString(), false);
    }


}