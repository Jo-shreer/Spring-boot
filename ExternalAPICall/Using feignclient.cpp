Calling External API Using FeignClient in Spring Boot
======================================================

Overview
--------
Feign is a declarative web service client. It allows you to call external REST APIs by simply creating an interface.

Steps:
1. Add dependency
2. Enable Feign
3. Create a Feign client interface
4. Autowire and use it in a service/controller

Step 1: Add Dependency (Maven)
------------------------------
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

  <dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>2022.0.3</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>


Step 2: Enable Feign Clients
@SpringBootApplication
@EnableFeignClients
public class FeignExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignExampleApplication.class, args);
    }
}

Step 3: Create Feign Client Interface
@FeignClient(name = "jsonPlaceholderClient", 
             url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderClient 
 {

    @GetMapping("/posts/{id}")
    Post getPostById(@PathVariable("id") Long id);
}

step 4
public class Post 
{
    private Long userId;
    private Long id;
    private String title;
    private String body;

    // Getters and Setters
}
step 5
@RestController
@RequestMapping("/api")
public class PostController 
{
    @Autowired
    private JsonPlaceholderClient client;

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) 
    {
        return client.getPostById(id);
    }
}


op
GET http://localhost:8080/api/post/1
{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit..."
}

