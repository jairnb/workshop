package com.workshop.company.service;

import com.workshop.company.entity.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class CompanyServiceTest {
    @Mock
    private Company companyMock;
    @Mock
    private ModelMapper modelMapper;
    @Autowired
    private ICompanyService underTest;


    @BeforeEach
    void setUp() {
    }
    @Test
    void save() {
        UUID companyId = UUID.randomUUID();

    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        UUID companyId = UUID.randomUUID();
        this.mockMvc.perform(get("/companies/"+companyId)).andDo(print()).andExpect(status().isOk());
//                .andExpect(content().string(containsString("Hello, World")));
    }
}