package th.co.ais.internal.sample.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import th.co.ais.internal.sample.employee.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserDetailRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserByUsername(String username) ;
}


