package org.workshop.companyservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.workshop.companyservice.dto.CompanyList;
import org.workshop.companyservice.entity.Company;
import org.workshop.companyservice.service.CompanyService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CompanyController.class)
@AutoConfigureMockMvc
class CompanyControllerUnitTest {


    @Autowired
    private CompanyController companyController;

    @MockBean
    private CompanyService companyServiceMock;

    @Autowired
    MockMvc mockMvc;

    UUID testId = UUID.randomUUID();

    List<Company> companyList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Company c1 = new Company();
        c1.setName("Test Company");
        Company c2 = new Company();
        c2.setName("C2 Company");
        c2.setId(testId);
        companyList = List.of(c1, c2);

    }

    @Test
    void shouldFindById() throws Exception {
        Company c2 = new Company();
        c2.setName("C2 Company");
        c2.setId(testId);

        Mockito.when(companyServiceMock.findById(testId)).thenReturn(c2);

        String json = """
                {
                    "name": "C2 Company",
                    "companyIdentifier": null,
                    "phoneNumber": 0,
                    "address": null
                }
                """;

        mockMvc.perform(get("/api/v1/company/"+testId.toString()))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }

    @Test
    void shouldUpdate() {
    }

    @Test
    void shouldCreate() throws Exception {
        Company c2 = new Company();
        c2.setName("C2 Company");

        Mockito.when(companyServiceMock.save(c2)).thenReturn(c2);

        String json = """
                {
                    "name": "C2 Company",
                    "companyIdentifier": null,
                    "phoneNumber": 0,
                    "address": null
                }
                """;

        mockMvc.perform(post("/api/v1/company")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(content().json(json));
    }

    @Test
    void shouldDelete() throws Exception {
        doNothing().when(companyServiceMock).delete(testId);

        mockMvc.perform(delete("/api/v1/company/"+testId))
                .andExpect(status().isNoContent());

        verify(companyServiceMock, times(1)).delete(testId);
    }

    @Test
    void shouldFindAllCompanies() throws Exception {

        String json = """
                {
                	"companies": [
                		{
                			"name": "Test Company",
                			"companyIdentifier": null,
                			"phoneNumber": 0,
                			"address": null
                		},
                		{
                			"name": "C2 Company",
                			"companyIdentifier": null,
                			"phoneNumber": 0,
                			"address": null
                		}
                	]
                }
                
                """;

        var companyListObject = new CompanyList();
        companyListObject.setCompanies(companyList);
        Mockito.when(companyServiceMock.findAll()).thenReturn(companyListObject);

        ResultActions resultActions = mockMvc.perform(get("/api/v1/company"))
                .andExpect(status().isOk())
                .andExpect(content().json(json));

        JSONAssert.assertEquals(json, resultActions.andReturn().getResponse().getContentAsString(), false);
    }
}