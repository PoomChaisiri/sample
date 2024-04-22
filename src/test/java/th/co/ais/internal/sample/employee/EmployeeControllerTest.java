package th.co.ais.internal.sample.employee;

import jakarta.validation.Valid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    MockMvc mockMvc;
    @Mock
    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        EmployeeController employeeController = new EmployeeController(employeeService);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController)
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("when perform on GET: me should return Hello, Employee!")
    void employeeMessage() throws Exception {
        mockMvc.perform(get("/me"))
                .andExpect(jsonPath("$.message", is("Hello, Employee!")))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("when perform on GET: /employee should return employee list")
    void employeeList() throws Exception {
        EmployeeResponse employeeResponseD = new EmployeeResponse();
        employeeResponseD.setEmpName("D");

        EmployeeResponse employeeResponseC = new EmployeeResponse();
        employeeResponseC.setEmpName("C");
        when(employeeService.getEmployeeList()).thenReturn(List.of(employeeResponseD, employeeResponseC));

        mockMvc.perform(get("/employee"))
                .andExpect(jsonPath("$[0].emp_name", is("D")))
                .andExpect(jsonPath("$[1].emp_name", is("C")))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).getEmployeeList();
    }

    @Test
    @DisplayName("when create employee on POST: / should return status 200 and body contain empName")
    void createWallet() throws Exception {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmpName("D");

        when(employeeService.createEmployee(any()))
                .thenReturn(employeeResponse);

        mockMvc.perform(
                        post("/employee")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON)
                                .content("{\"empName\":\"D\"}")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.emp_name", is("D")));
    }
}
