→ Used to resolve ambiguity when multiple beans of the same type exist  
→ Specifies which bean to inject

Example:


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Engine engine;

    @Autowired
    public Car(@Qualifier("v8Engine") Engine engine) 
    {
        this.engine = engine;
    }
}

@Component("v8Engine")
public class V8Engine extends Engine 
{
    @Override
    public void start() 
    {
        System.out.println("V8 engine started.");
    }
}

@Component("v6Engine")
public class V6Engine extends Engine 
{
    @Override
    public void start() 
    {
        System.out.println("V6 engine started.");
    }
}
