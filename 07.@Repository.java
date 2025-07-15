→ Marks the class as a DAO (data access object)  
→ Enables exception translation for database operations

Example:


import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public void saveUser() 
    {
        System.out.println("User saved to DB.");
    }
}
