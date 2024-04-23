package th.co.ais.internal.sample.authController;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {


    @Value("${word.something}")
    private String word = "";

    @Autowired
    AppProperties appProperties;

    @GetMapping("")
    public String greeting() {
        return "Hi "+word+":"+appProperties.getName();
    }
}

