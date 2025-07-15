→ Marks a method to be called just before the bean is destroyed  
→ Used for cleanup tasks

Example:

import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection 
{
    @PreDestroy
    public void close() 
    {
        System.out.println("Database connection closed.");
    }
}
