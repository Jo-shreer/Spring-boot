Testing Spring Boot Service with Mocked Repository
==================================================

1️⃣ Service Class (Business Logic)
---------------------------------
package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService 
{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}

2️⃣ Repository Interface
------------------------
package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> 
{
    Optional<User> findByEmail(String email);
}

3️⃣ Model Class
--------------
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
    public User(String name, String email) 
    {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters omitted for brevity
}

4️⃣ Unit Test Class
-------------------
package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest 
{
    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void testGetAllUsers() {
        List<User> mockUsers = Arrays.asList(
                new User("Alice", "alice@example.com"),
                new User("Bob", "bob@example.com")
        );

        when(userRepository.findAll()).thenReturn(mockUsers);
        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testGetUserByEmail() 
    {
        User user = new User("Charlie", "charlie@example.com");
        when(userRepository.findByEmail("charlie@example.com"))
        .thenReturn(Optional.of(user));

        Optional<User> result = userService.getUserByEmail("charlie@example.com");

        assertTrue(result.isPresent());
        assertEquals("Charlie", result.get().getName());
        verify(userRepository, times(1)).findByEmail("charlie@example.com");
    }

    @Test
    public void testSaveUser() 
    {
        User user = new User("David", "david@example.com");
        when(userRepository.save(user)).thenReturn(user);
      
        User savedUser = userService.saveUser(user);
        assertNotNull(savedUser);
        assertEquals("David", savedUser.getName());
        verify(userRepository, times(1)).save(user);
    }
}

---------------------------------------------------
How it works:
--------------
- `@Mock` creates a mock instance of UserRepository  
- `MockitoAnnotations.openMocks(this)` initializes mocks  
- `when(...).thenReturn(...)` defines mock behavior  
- `verify(...)` checks if mocked methods were called expected times  
- Tests verify service logic without connecting to database

---------------------------------------------------
Run Tests:
-----------
- Run from IDE or  
- Use `mvn test` / `gradle test` commands

  
