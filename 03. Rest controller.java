@RestController
→ Combines @Controller and @ResponseBody  
→ Handles REST requests and returns data (usually JSON)

Example:

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController 
{

    @GetMapping("/hello")
    public String sayHello() 
    {
        return "Hello, REST!";
    }
}
