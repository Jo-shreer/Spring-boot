3. Request Scope (Web apps only)  
- New instance per HTTP request.

Example:

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RequestScopedBean 
{
    public RequestScopedBean() 
    {
        System.out.println("RequestScopedBean instance created");
    }
}
