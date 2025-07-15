
@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService() {
        // Here bookRepository is still 
      //null because injection happens after 
       // constructor
        System.out.println(bookRepository);  // prints null -> risky!
    }

    public void doSomething() {
        bookRepository.findAll();  // risk of NullPointerException if called too early
    }
}
