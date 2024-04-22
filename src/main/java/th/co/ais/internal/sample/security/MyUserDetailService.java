package th.co.ais.internal.sample.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserDetailRepository userDetailRepository;

    private final JwtService jwtService;

    public MyUserDetailService(UserDetailRepository userDetailRepository, JwtService jwtService) {
        this.userDetailRepository = userDetailRepository;
        this.jwtService = jwtService;
    }

    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userDetails = userDetailRepository.findUserByUsername(username);

        if(userDetails == null) {
            throw new UsernameNotFoundException("Unknown user "+ username);
        }
        CustomUserDetail user = new CustomUserDetail(userDetails.getUsername(),userDetails.getPassword());
        user.setRoles(List.of(userDetails.getRoles()));
        user.setPermissions(List.of(userDetails.getPermissions()));
        user.isAccountNonExpired();
        user.isEnabled();
        user.isCredentialsNonExpired();
        user.isAccountNonLocked();
        return user;

    }

    public String generateJwt(String username) {
        return jwtService.generateToken(this.loadUserByUsername(username));
    }
}


