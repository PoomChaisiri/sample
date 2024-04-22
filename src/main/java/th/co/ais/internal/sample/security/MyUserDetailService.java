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

    public MyUserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
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
        return user;

    }
}


