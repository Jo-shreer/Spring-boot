JUnit Testing in Spring Boot
============================

Overview:
---------
Spring Boot integrates easily with JUnit 5 (JUnit Jupiter) for unit and 
integration testing.  
You can test components like REST controllers, services, and 
repositories using annotations and utilities provided by Spring Boot Test.

Key Annotations:
----------------
@SpringBootTest 
  → Boots the full Spring application context for integration tests.  
@WebMvcTest               
 → Loads only Spring MVC components for controller testing.  
@MockBean                
  → Creates mock objects for Spring Beans.  
@Autowired               
  → Injects dependencies in test classes.

---------------------------------------------------
Sample Spring Boot REST Controller
---------------------------------------------------
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GreetingController 
{

    @GetMapping("/greet")
    public String greet() {
        return "Hello, Spring Boot!";
    }
}

---------------------------------------------------
JUnit Test for Controller (using @WebMvcTest)
---------------------------------------------------
package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GreetingController.class)
public class GreetingControllerTest 
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreet() throws Exception 
    {
        mockMvc.perform(get("/api/greet"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, Spring Boot!"));
    }
}

---------------------------------------------------
How This Works:
---------------
- @WebMvcTest loads only the web layer (controllers, filters, etc.)  
- MockMvc allows sending HTTP requests and asserting responses without
  starting the server  
- `perform(get(...))` simulates a GET request  
- `andExpect(...)` asserts expected HTTP status and response content

---------------------------------------------------
Running Tests:
---------------
- Run tests from IDE (Right-click test class → Run)  
- Run `mvn test` or `gradle test` in terminal

---------------------------------------------------
Summary:
---------
✅ Use @WebMvcTest for controller layer tests  
✅ Use MockMvc for simulating HTTP requests  
✅ Use @SpringBootTest for full integration tests loading entire context  
✅ Combine with @MockBean for mocking dependencies

  
