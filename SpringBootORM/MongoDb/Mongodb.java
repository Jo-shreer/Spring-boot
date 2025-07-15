MongoDB with Spring Boot (Java)
===============================

📌 Overview:
------------
MongoDB is a NoSQL document database that stores data in JSON-like BSON documents.  
Spring Boot supports MongoDB out-of-the-box using Spring Data MongoDB.

🔥 Key Features:
---------------
- Documents (not tables), stored in collections
- Schema-less (dynamic structure)
- Integrated with Spring Boot via `spring-boot-starter-data-mongodb`

---------------------------------------------------
1️⃣ Add Maven Dependency
---------------------------------------------------
<!-- pom.xml -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>

---------------------------------------------------
2️⃣ Configure MongoDB Connection
---------------------------------------------------
# application.properties
spring.data.mongodb.uri=mongodb://localhost:27017/mydb

---------------------------------------------------
3️⃣ Create MongoDB Document Class
---------------------------------------------------
package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;

    // Constructors
    public User() {}
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}

---------------------------------------------------
4️⃣ Create Repository Interface
---------------------------------------------------
package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}

---------------------------------------------------
5️⃣ Create REST Controller
---------------------------------------------------
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }
}

---------------------------------------------------
6️⃣ Example MongoDB Document (Stored Record)
---------------------------------------------------
{
    "_id": "60d4f1cbe77f4c1234567890",
    "name": "Alice",
    "email": "alice@example.com"
}

---------------------------------------------------
✅ Summary
---------------------------------------------------
- Use `@Document` for MongoDB entities.
- Use `MongoRepository` for CRUD operations.
- Spring Boot auto-configures the connection.
- Flexible, schema-less, and fast for many applications.

  
