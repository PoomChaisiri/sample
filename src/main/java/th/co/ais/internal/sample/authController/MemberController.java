package th.co.ais.internal.sample.authController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @GetMapping("")
    public String greeting() {
        return "Hi am Member";
    }
}
