→ Used to define and register a custom bean  
→ Declared inside a class annotated with @Configuration

Example:

  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig 
{

    @Bean
    public Car car() 
    {
        return new Car();
    }
}
