✅ AOP (Aspect-Oriented Programming) in Spring Boot – Full Guide with @Around Advice

────────────────────────────────────────────
🔹 What is AOP?
────────────────────────────────────────────
AOP = Aspect-Oriented Programming

It allows separating cross-cutting concerns like:
- Logging
- Security
- Transactions
- Caching
- Monitoring

Instead of writing repetitive code in every method
AOP lets you write reusable logic and apply it to multiple
methods automatically.

────────────────────────────────────────────
🔹 Core AOP Concepts
────────────────────────────────────────────

| Term         | Description                                                     |
|--------------|-----------------------------------------------------------------|
| Aspect       | A class with cross-cutting logic                                |
| Join Point   | A point in program execution (e.g., method call)                |
| Advice       | Code executed at a join point (@Before, @After, @Around, etc.)  |
| Pointcut     | Expression to match join points                                 |
| Weaving      | Linking aspect logic into the target method                     |

────────────────────────────────────────────
🔹 Example Project: Logging Method Calls
────────────────────────────────────────────
✅ Spring AOP Execution Expression Explained

────────────────────────────────────────────
🔹 Syntax Used:
────────────────────────────────────────────
"execution(* com.example.aopdemo.service.*.*(..))"
This is a **pointcut expression** in Spring AOP. 
It defines **which methods** the advice should apply to.

Let's break it down:
▶️ `execution(...)`  
This designator is used to match **method execution join points** — 
  it means "when a method is called".
▶️ `*` (return type)  
This matches **any return type** (void, int, String, etc.).
▶️ `com.example.aopdemo.service.*` (class)  
Matches **any class** in the package `com.example.aopdemo.service`.
▶️ `.*` (method)  
Matches **any method name** inside those classes.
▶️ `(..)` (arguments)  
Matches **any number and type of parameters** (zero or more).

────────────────────────────────────────────
🔹 In Summary:
────────────────────────────────────────────
`execution(* com.example.aopdemo.service.*.*(..))` matches:
- Any return type
- Any method name
- Any number/type of parameters
- In **any class** under `com.example.aopdemo.service`

```java
public void doSomething()
public int calculate(int a, int b)
public String findById(String id)
  

  
📄 AopDemoApplication.java
```java
  
@SpringBootApplication
public class AopDemoApplication 
{
    public static void main(String[] args) 
   {
        ConfigurableApplicationContext context = SpringApplication.run(AopDemoApplication.class, args);
        MyService service = context.getBean(MyService.class);
        service.doSomething();
    }
}

@Service
public class MyService 
{
    public void doSomething() 
    {
        System.out.println("✅ Inside MyService.doSomething()");
    }
}


@Aspect // 🔹 This class is an Aspect — it contains cross-cutting logic.
@Component // 🔹 Marks it as a Spring bean so Spring can detect it.
public class LoggingAspect 
{
    // 🔸 ADVICE: Runs BEFORE any method matched by the pointcut.
    @Before("execution(* com.example.aopdemo.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) 
    {
        // 🔹 POINTCUT: Matches all methods in classes inside 'service' package.
        // - *: any return type
        // - com.example.aopdemo.service.*: any class in that package
        // - .*: any method
        // - (..): any parameters
        System.out.println("➡️ Before method: " + joinPoint.getSignature().getName());
    }

    // 🔸 ADVICE: Runs AFTER any matched method has completed 
         //(normally or with exception).
    @After("execution(* com.example.aopdemo.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) 
    {
        // 🔹 Same pointcut: applies after method execution.
        System.out.println("⬅️ After method: " + joinPoint.getSignature().getName());
    }

    // 🔸 ADVICE: Wraps around the method execution — 
    // allows code to run BEFORE and AFTER.
  
    @Around("execution(* com.example.aopdemo.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable 
    {
        // 🔹 Same pointcut: wraps methods in 'service' package.
        long start = System.currentTimeMillis();
        System.out.println("🔄 Around - Before: " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();  // 🔸 Call the actual target method.

        long duration = System.currentTimeMillis() - start;
        System.out.println("🔄 Around - After: " + 
                           joinPoint.getSignature().getName() + 
                           " | Duration: " + duration + "ms");

        return result;
    }
}




  
