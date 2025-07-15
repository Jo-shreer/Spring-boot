📌 What is @Value?

`@Value` is used to inject values from:
- application.properties / application.yml
- Environment variables
- Default values
- System properties
- Expressions (SpEL)

────────────────────────────────────────────
🔹 Example 1: Inject value from application.properties
────────────────────────────────────────────

📄 application.properties
app.name=MySpringApp

📄 ExampleUsage.java
```java
@Component
public class ExampleUsage {

    @Value("${app.name}")
    private String appName;

    @PostConstruct
    public void show() 
    {
        System.out.println("App Name: " + appName);
    }
}

op
App Name: MySpringApp

2. with default value
  
@Value("${some.property:DefaultValue}")
private String value;

Example 3: Inject from Environment Variable
 @Value("${JAVA_HOME}")
private String javaHome;

Example 4: Use Expression (SpEL)
                           
@Value("#{2 * 10}")
private int result;  // ➜ 20

                           


  
