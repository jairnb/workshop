package com.workshop.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

/*
*I'm not quite sure if those are unit tests, but fuck it
* */

@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc
class EmployeeControllerIntegrationTest {

    @Autowired
    private EmployeeController employeeController;




}