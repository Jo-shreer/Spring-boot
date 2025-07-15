2. Prototype Scope  
- A new instance of the bean is created every time it is requested
  from the container.  
- Useful for stateful beans.

Example:

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean 
{
    public PrototypeBean() 
   {
        System.out.println("PrototypeBean instance created");
    }
}
