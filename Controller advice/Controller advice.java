/*
✅ Spring Boot ControllerAdvice Example (Copy‑Ready)

We’ll create:
1. A simple REST controller
2. A custom exception
3. A @ControllerAdvice class to handle exceptions globally
*/

// 1️⃣ Custom Exception
package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException 
{
    public ResourceNotFoundException(String message) 
    {
        super(message);
    }
}

// 2️⃣ REST Controller
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController 
{
    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id) 
    {
        if (id == 0) 
        {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        return "User with id: " + id;
    }
}

// 3️⃣ ControllerAdvice (Global Exception Handler)
package com.example.demo.advice;

import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler 
{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) 
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) 
    {
        return new ResponseEntity<>("Something went wrong: " + ex.getMessage(),
                                    HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


How it works:
If you call GET /users/1 → returns "User with id: 1".
If you call GET /users/0 → throws ResourceNotFoundException, 
handled by @ControllerAdvice, returns 404 with message
"User not found with id: 0".

Any other unhandled exception will return a 500 Internal 
Server Error with a custom message.



  
