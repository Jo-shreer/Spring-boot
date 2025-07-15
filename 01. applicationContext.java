/*
Spring Boot creates an ApplicationContext automatically.
It scans the classpath for @Component classes.
It wires dependencies using @Autowired.
You get your beans ready to use — no need to manually configure.
  */

package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception 
    {
        System.out.println("Listing all beans provided by Spring Boot:");

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames); // Sort alphabetically

        for (String name : beanNames) 
        {
            System.out.println(name);
        }
    }
}


op
 Listing all beans provided by Spring Boot:
applicationConversionService
beanNameViewResolver
commandLineRunner
demoApplication
dispatcherServlet
messagePrinter
messageService
...
 
