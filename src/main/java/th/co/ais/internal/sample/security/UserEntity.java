package th.co.ais.internal.sample.security;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_entity")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true)
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String roles;
    @NotBlank
    private String permissions;
}
