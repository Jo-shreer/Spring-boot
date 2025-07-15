5. Application Scope (Web apps only)  
- One instance per ServletContext (application-wide).

Example:

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_APPLICATION)
public class ApplicationScopedBean 
{
    public ApplicationScopedBean() 
    {
        System.out.println("ApplicationScopedBean instance created");
    }
}
