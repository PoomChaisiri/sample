package th.co.ais.internal.sample.authController;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.ais.internal.sample.dto.UserRequestDTO;
import th.co.ais.internal.sample.dto.UserResponseDTO;
import th.co.ais.internal.sample.employee.EmployeeService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<UserResponseDTO> createUser(final @Valid @RequestBody UserRequestDTO request) {
        return new ResponseEntity<>(userService.create(request), HttpStatus.CREATED);
    }

}
