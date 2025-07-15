→ Marks the class as a service (business logic)  
→ Automatically picked up by component scanning

Example:


import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void pay() 
    {
        System.out.println("Payment processed.");
    }
}
