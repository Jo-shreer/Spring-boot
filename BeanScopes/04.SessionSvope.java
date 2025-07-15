4. Session Scope (Web apps only)  
- New instance per HTTP session.

Example:

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SessionScopedBean 
{
    public SessionScopedBean() 
    {
        System.out.println("SessionScopedBean instance created");
    }
}
