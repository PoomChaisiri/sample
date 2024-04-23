package th.co.ais.internal.sample.authController;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "detail.var")
public class AppProperties{
    public String name;
    public String email;
    public String description;
}
