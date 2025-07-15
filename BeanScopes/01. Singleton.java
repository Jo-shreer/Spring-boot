Bean Scopes in Spring Boot:

1. Singleton Scope (Default)  
- Only one instance of the bean is created per Spring container.  
- Shared and reused throughout the application lifecycle.

Example:

import org.springframework.stereotype.Component;

@Component
public class SingletonBean 
{
    public SingletonBean() 
    {
        System.out.println("SingletonBean instance created");
    }
}
