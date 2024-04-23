package th.co.ais.internal.sample.employee;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.ais.internal.sample.log.LogResponse;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<EmployeeResponse> getEmployeeList() {
        return this.employeeService.getEmployeeList();
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Integer id) {
        return this.employeeService.getEmployeeById(id);
    }

    @GetMapping("/query/{id}")
    public EmployeeResponse getEmployeeByIdQuery(@PathVariable Integer id) {
        return this.employeeService.getEmployeeByIdQuery(id);
    }

    @PostMapping("")
    public EmployeeResponse createEmployee(@Valid @RequestBody EmployeeRequest requestDto) throws Exception {
        return this.employeeService.createEmployee(requestDto);
    }

    @PutMapping("/{id}")
    public EmployeeResponse editEmployee(@PathVariable Integer id, @RequestBody EmployeeRequest requestDto) {
        return this.employeeService.editEmployeeById(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        this.employeeService.deleteEmployeeById(id);
        return "success";
    }

    @GetMapping("/join")
    public ResponseEntity<List<Object>> getEmployeeWithTimestamp() {
        return ResponseEntity.ok(this.employeeService.getEmployeeWithTimestamp());
    }

    @GetMapping("/me")
    ResponseReturn me() {
        return new ResponseReturn("Hello, Employee!");
    }
}
