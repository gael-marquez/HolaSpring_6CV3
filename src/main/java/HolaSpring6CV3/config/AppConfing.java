package HolaSpring6CV3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfing {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
