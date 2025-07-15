→ Marks a class as a Spring-managed component (generic stereotype)  
→ Detected via component scanning

Example:
import org.springframework.stereotype.Component;

@Component
public class Engine 
{
    public void start() {
        System.out.println("Engine started.");
    }
}
