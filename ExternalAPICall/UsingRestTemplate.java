Calling an External API in Spring Boot
======================================

Overview
--------
To call external REST APIs in Spring Boot, you can use:

1. RestTemplate (commonly used)
2. WebClient (reactive approach, newer)
3. FeignClient (declarative style)

Here we'll use **RestTemplate** with a simple GET example.

Step 1: Add RestTemplate Bean
-----------------------------
```java

  
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() 
    {
        return new RestTemplate();
    }
  }


  @Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    public String getPostTitle() 
    {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<String> response = restTemplate.
                                getForEntity(url, String.class);
        return response.getBody();
    }
}


@RestController
@RequestMapping("/api")
public class ApiController 
{

    @Autowired
    private ApiService apiService;

    @GetMapping("/external")
    public String getExternalData() 
    {
        return apiService.getPostTitle();
    }
}

op
  GET http://localhost:8080/api/external

{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit..."
}




