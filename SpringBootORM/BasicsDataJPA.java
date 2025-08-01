o/*
  📌 What is ORM?

- ORM stands for **Object-Relational Mapping**.
- It allows you to interact with relational databases using **Java objects**,
  instead of SQL queries.
- Spring Boot typically uses **Hibernate** as the default 
  JPA (Java Persistence API) implementation.

✅ Benefits of ORM:
- Less SQL code — use Java classes and annotations.
- Maps Java objects to database tables.
- Handles CRUD operations easily.
- Supports relationships (OneToMany, ManyToOne, etc.).

🔧 ORM in Spring Boot uses:
- Spring Data JPA
- Hibernate (behind the scenes)
- Annotations like @Entity, @Id, @OneToMany, etc.

  */

📦 Maven Dependency (Spring Data JPA + H2):

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

*******†**********************†****************************

⚙️ 5. application.properties

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
  
  
  🧩 1. Entity Class (User.java)

import jakarta.persistence.*;

@Entity
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Getters and Setters
}

***********_---------_-----------------------------------------

📁 2. Repository Interface (UserRepository.java)

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> 
{
    // Inherits save(), findAll(), deleteById(), etc.
}



🔧 3. Service Class (UserService.java)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService 
{
    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String email) 
    {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

🌐 4. REST Controller (UserController.java)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestParam String name, 
                            @RequestParam String email) 
    {
        return userService.createUser(name, email);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}


  ▶️ Run & Test:

POST Request:
URL: http://localhost:8080/users?name=John&email=john@example.com

GET Request:
URL: http://localhost:8080/users

🖨️ Console Output:

Hibernate: insert into user (email, name) values (?, ?)
Hibernate: select user0_.id as id1_0_, user0_.email as email2_0_, user0_.name as name3_0_ from user user0_



