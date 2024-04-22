package th.co.ais.internal.sample.authController;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String greeting() {
        return "Hi am Admin";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/role")
    public String authorizeRole() {
        return "I has role admin";
    }

    @PreAuthorize("hasAuthority('ADMIN_READ')")
    @GetMapping("/authority")
    public String authorizeAuthority() {
        return "I has Authority ADMIN_READ";
    }
}
