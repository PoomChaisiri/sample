package th.co.ais.internal.sample.employee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> getEmployeeList() {
        return employeeRepository.findAll().stream().map(Employee::toResponse).toList();
    }

    public EmployeeResponse createEmployee(EmployeeRequest requestDto) throws Exception {
        Employee employee = new Employee();
        employee.setEmpName(requestDto.getEmpName());
        employeeRepository.save(employee);
        return employee.toResponse();
    }


    public EmployeeResponse getEmployeeById(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id.longValue());
        return optionalEmployee.get().toResponse();
    }

    public EmployeeResponse getEmployeeByIdQuery(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findEmployeeByIdQuery(id.longValue());
        return optionalEmployee.get().toResponse();
    }

    public EmployeeResponse editEmployeeById(Integer id, EmployeeRequest requestDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id.longValue());
        Employee employee = optionalEmployee.get();
        employee.setEmpName(requestDto.getEmpName());
        employeeRepository.save(employee);
        return employee.toResponse();
    }


    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(Long.valueOf(id));
    }

    public List<Object> getEmployeeWithTimestamp(){
        return employeeRepository.findEmployeeWithTimestamp();
    }
}
