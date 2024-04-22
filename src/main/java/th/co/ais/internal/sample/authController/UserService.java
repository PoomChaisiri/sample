package th.co.ais.internal.sample.authController;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import th.co.ais.internal.sample.dto.UserRequestDTO;
import th.co.ais.internal.sample.dto.UserResponseDTO;
import th.co.ais.internal.sample.security.UserDetailRepository;
import th.co.ais.internal.sample.security.UserEntity;

@Service
public class UserService {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final UserDetailRepository userRepository;

    public UserService(UserDetailRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO create(final UserRequestDTO request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(encoder.encode(request.getPassword()));
        userEntity.setRoles(request.getRoles());
        userEntity.setPermissions(request.getPermissions());
        UserEntity result = this.userRepository.save(userEntity);
        return new UserResponseDTO(result.getUsername());
    }
}
