package th.co.ais.internal.sample.authController;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.co.ais.internal.sample.dto.AuthRequestDTO;
import th.co.ais.internal.sample.security.MyUserDetailService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailService myUserDetailService;

    public AuthenticationController(AuthenticationManager authenticationManager, MyUserDetailService myUserDetailService) {
        this.authenticationManager = authenticationManager;
        this.myUserDetailService = myUserDetailService;
    }


    @PostMapping(value = "/authenticate")
    public String authenticated(@RequestBody AuthRequestDTO authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        return myUserDetailService.generateJwt(authenticationRequest.getUsername());
    }
}
