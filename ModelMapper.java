📌 What is ModelMapper?

ModelMapper is a Java library used to simplify object mapping.
It automatically maps fields between objects with similar structures 
  — such as Entity ↔ DTO or ViewModel ↔ Domain Model. 
It's often used in Spring Boot applications to reduce boilerplate mapping code.

🛠️ Without ModelMapper (Manual Mapping):

public UserDTO convertToDto(User user) {
    UserDTO dto = new UserDTO();
    dto.setName(user.getName());
    dto.setEmail(user.getEmail());
    return dto;
}

⚙️ With ModelMapper (Automatic Mapping):

ModelMapper modelMapper = new ModelMapper();
UserDTO dto = modelMapper.map(user, UserDTO.class);

This replaces the manual field copying with one line, 
  reducing boilerplate and improving readability.

⚠️ Issues / Limitations of ModelMapper:

1. Performance: Uses reflection; may be slower for large data sets.
2. Silent Failures: If fields don’t match, it may fail silently.
3. Debugging: Harder to trace when auto-mapping goes wrong.
4. Complex Mappings: Requires customization for nested or differently named fields.

✅ Advantages of ModelMapper:

1. Reduces repetitive boilerplate code.
2. Automatically maps fields with the same name/type.
3. Supports nested and deep mapping.
4. Clean, readable, and maintainable code.
5. Easy integration with Spring Boot.

📎 Use Case:

Ideal for mapping between layers:
- Entity ↔ DTO (for APIs)
- Domain ↔ ViewModel (for MVC apps)
- Database ↔ Response Object (for REST APIs)

