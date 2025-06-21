package com.dsr;

import com.dsr.dtos.EmployeeDto;
import com.dsr.entity.Account;
import com.dsr.entity.Employee;
import com.dsr.repositories.AccountRepository;
import com.dsr.repositories.EmployeeRepository;
import com.dsr.service.EmployeeService;
import com.dsr.service.EmployeeServiceImplementation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@DataJpaTest
class SpringDemoApplicationTests {

    @Autowired
    MockMvc mockM;


	@Test
	void endpointTest() throws Exception {
		mockM.perform(MockMvcRequestBuilders.get("/api/admin/account")).andExpect(
				MockMvcResultMatchers.status().isOk());
	}
	@Test
	void endpointTest2() throws Exception {
		mockM.perform(MockMvcRequestBuilders.get("/api/admin/employee/2")).andExpect(
				MockMvcResultMatchers.status().isOk());
	}

	@Test
	void endpointTest3() throws Exception {
		mockM.perform(MockMvcRequestBuilders.get("/api/admin/employee/2")).andExpect(
				MockMvcResultMatchers.status().isOk());
	}

    @InjectMocks
	EmployeeServiceImplementation empService;

    @MockBean
    EmployeeRepository empRepo;


    @Test
    void repoTest() throws Exception {
	Employee testEmployee = new Employee(223,442,"James","James@mail.com","Manager",false, LocalDate.now(),"Alex",LocalDate.now(),"Alex");
    when(empRepo.findById(223)).thenReturn(Optional.of(testEmployee));
	//Assertion will be to confirm certain logic points
		EmployeeDto someValue = empService.findEmployeeOnID(3);
		assertEquals(someValue.getEmp_id(), testEmployee.getEmp_id());
    }



}
