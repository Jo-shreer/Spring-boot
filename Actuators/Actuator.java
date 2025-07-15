/*
Spring Boot Actuator:

- Actuator provides production-ready features to help monitor
  and manage your Spring Boot application.  
- It exposes endpoints to check health, metrics, environment, and more.

How to use:

1. Add dependency in your pom.xml (for Maven):

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
  
2. By default, actuator exposes endpoints like
  `/actuator/health` and `/actuator/info`.

3. Example Application:
*/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActuatorExampleApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(ActuatorExampleApplication.class, args);
    }
}


/*
op

4. Access health endpoint in the browser or curl:
http://localhost:8080/actuator/health
Sample output:
{
  "status": "UP"
}

You can configure which endpoints to expose in application.properties:
management.endpoints.web.exposure.include=health,info,metrics

*/


  
  
