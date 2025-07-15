→ Injects one Spring bean into another  
→ Can be used on fields, constructors, or setters

Example:


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car 
{
    public void drive() 
    {
        System.out.println("Driving...");
    }
}

@Component
public class Driver 
{
    @Autowired
    private Car car;

    public void startTrip() {
        car.drive();
    }
}
