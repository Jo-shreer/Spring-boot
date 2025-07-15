→ Marks a class as a source of bean definitions  
→ Used for Java-based Spring configuration

Example:


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig 
{
    @Bean
    public Car car() {
        return new Car();
    }
}
