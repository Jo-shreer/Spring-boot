
@Component
public class BookService 
{

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) 
    {
        this.bookRepository = bookRepository; // guaranteed non-null here
    }

    public void doSomething() 
    {
        bookRepository.findAll();  // safe to use
    }
}
