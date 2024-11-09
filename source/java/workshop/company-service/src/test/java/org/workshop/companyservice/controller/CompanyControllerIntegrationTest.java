package org.workshop.companyservice.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.workshop.companyservice.dto.CompanyList;
import org.workshop.companyservice.service.CompanyService;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest //(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS)
class CompanyControllerIntegrationTest {


    @Autowired
    private CompanyController companyController;

    @MockBean
    private CompanyService companyServiceMock;

    @Test
    void save() {
    }

    @Test
    void findAll() {
        Mockito.when(companyServiceMock.findAll()).thenReturn(new CompanyList());

        companyController.findAll();

        Mockito.verify(companyServiceMock, Mockito.times(1)).findAll();
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}