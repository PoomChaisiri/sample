package th.co.ais.internal.sample.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;


    @Test
    @DisplayName("should be able to get all employee")
    void shouldBeAbleToGetEmployee() {
        List<Employee> employeeList = new ArrayList<>() ;
        Employee employee1 = new Employee(1,"D");
        Employee employee2 = new Employee(2,"C");
        employeeList.add(employee1);
        employeeList.add(employee2);

        when(employeeRepository.findAll()).thenReturn(employeeList);

        List<EmployeeResponse> result = employeeService.getEmployeeList();

        assertEquals("D", result.get(0).getEmpName());
        assertEquals("C", result.get(1).getEmpName());

    }
}
