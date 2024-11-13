package org.workshop.companyservice.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.workshop.companyservice.entity.Company;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Testcontainers
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepositoryIntegrationTest {

    @Container
    @ServiceConnection
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16.0");
    private UUID uuid = UUID.fromString("b299ecea-c4a0-4e8c-9094-88792108adce");
    @Autowired
    CompanyRepository companyRepository;

    @BeforeEach
    void setUp() {
        Company c1 = new Company();
        c1.setName("Test Company");
        Company c2 = new Company();
        c2.setName("C2 Company");
        List<Company> companies = List.of(c1, c2);
        companyRepository.saveAll(companies);
    }

    @Test
    public void connectionCheck(){
        assertThat(postgreSQLContainer.isCreated()).isTrue();
        assertThat(postgreSQLContainer.isRunning()).isTrue();
    }


    @Test
    void shouldReturnAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        assertEquals(companies.size(), 2);
    }

    @Test
    void shouldReturnCorrectCompanyName() {
        List<Company> companies = companyRepository.findAll();
        assertEquals(companies.getFirst().getName(), "Test Company");
    }

}