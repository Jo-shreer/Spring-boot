

→ Marks a method to be executed after dependency injection is done  
→ Used for initialization logic

Example:

  
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection 
{

    @PostConstruct
    public void init() 
    {
        System.out.println("Database connection initialized.");
    }
}
