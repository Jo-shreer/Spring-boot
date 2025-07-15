/*
Spring Boot uses the core Spring Framework bean lifecycle. 
When a bean is created and managed by Spring’s ApplicationContext,
it goes through several phases:

1. Instantiation
Spring creates an instance of the bean by calling its constructor.

2. Populate Properties (Dependency Injection)
Spring injects dependencies into the bean’s fields or setters. 
This happens using annotations like @Autowired or via constructor injection.

3. BeanNameAware & BeanFactoryAware (Optional)
If the bean implements interfaces like BeanNameAware or BeanFactoryAware, 
Spring passes the bean’s name or a reference to the BeanFactory to the bean.

4. Pre-initialization (BeanPostProcessor - before init)
Spring calls any registered BeanPostProcessor methods before 
the bean’s initialization callbacks.

5. Initialization
Spring calls initialization callbacks such as:
Methods annotated with @PostConstruct
Custom init methods specified via init-method or
InitializingBean.afterPropertiesSet()

6. Post-initialization (BeanPostProcessor - after init)
Spring calls BeanPostProcessor methods after initialization callbacks.

7. Bean Ready to Use
The bean is fully initialized and ready to be used in the application.

8. Destruction (On Application Shutdown)
When the application context is closed, Spring calls destruction callbacks:
Methods annotated with @PreDestroy
Custom destroy methods specified via destroy-method or DisposableBean.destroy()



1. Instantiation (constructor)
2. Dependency Injection
3. BeanNameAware, BeanFactoryAware callbacks (optional)
4. BeanPostProcessor before init
5. Initialization (@PostConstruct, init-method)
6. BeanPostProcessor after init
7. Bean ready to use
8. Destruction (@PreDestroy, destroy-method)


*/

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    public MyBean() 
    {
        System.out.println("1. Bean instantiated");
    }

    @PostConstruct
    public void init() 
    {
        System.out.println("5. PostConstruct - Initialization logic");
    }

    @PreDestroy
    public void cleanup() 
    {
        System.out.println("8. PreDestroy - Cleanup logic");
    }
}
