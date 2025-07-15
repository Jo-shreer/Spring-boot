/*

@SpringBootApplication  
→ Automatically configures the application,  
→ Scans for components,  
→ Registers them as Spring beans.

SpringApplication.run(...)  
→ Launches the Spring Boot application,  
→ Starts the embedded web server (like Tomcat) automatically.

@Configuration  
→ Marks the class as a source of Spring bean definitions,  
→ Allows methods annotated with @Bean to be managed by Spring's container.

@EnableAutoConfiguration  
→ Enables Spring Boot's auto-configuration feature,  
→ Automatically configures beans based on the classpath and defined properties.

@ComponentScan  
→ Tells Spring to scan the current package and sub-packages,  
→ Automatically detects classes annotated with @Component, @Service, @Repository, and @Controller.

  */

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
