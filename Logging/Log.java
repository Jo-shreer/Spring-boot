Logging in Spring Boot
======================

Overview:
---------
Spring Boot uses SLF4J (Simple Logging Facade for Java) as a 
  logging API and Logback as the default implementation.

✔️ Features:
- Uses SLF4J for abstraction.
- Default: Logback.
- Configurable via application.properties or application.yml.
- Supports console/file logging and custom patterns.

---------------------------------------------------
1. Basic Logging Example in Java Class
---------------------------------------------------
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyService 
{
    private static final Logger logger = LoggerFactory
                                         .getLogger(MyService.class);

    public void doWork() 
    {
        logger.info("✅ Starting work...");
        logger.debug("🐞 Debugging details...");
        logger.warn("⚠️ Warning issued!");
        logger.error("❌ An error occurred.");
    }
}

---------------------------------------------------
2. Logging Levels
---------------------------------------------------
TRACE → Most detailed logs.  
DEBUG → Developer-level logs.  
INFO  → General app info (default).  
WARN  → Potential issues.  
ERROR → Application errors/exceptions.

---------------------------------------------------
3. Configuration (application.properties)
---------------------------------------------------
logging.level.root=INFO
logging.level.com.example=DEBUG
logging.file.name=logs/app.log
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n

---------------------------------------------------
4. Configuration (application.yml)
---------------------------------------------------
logging:
  level:
    root: INFO
    com.example: DEBUG
  file:
    name: logs/app.log
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} - %msg%n"

---------------------------------------------------
5. Custom Log Pattern (logback-spring.xml)
---------------------------------------------------
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>logs/app.log</file>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="INFO">
        <appender-ref ref="FILE" />
    </root>
</configuration>

---------------------------------------------------
6. Summary
---------------------------------------------------
✅ SLF4J API with Logback default  
✅ Use LoggerFactory for log creation  
✅ Configure levels and output in application.properties or YAML  
✅ Logs go to console by default  
✅ Optional: Write logs to file or customize format via logback-spring.xml  
  
