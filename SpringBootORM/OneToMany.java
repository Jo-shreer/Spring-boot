
📘 Use Case:

One `Author` can write many `Book`s  
This is a classic One-to-Many relationship:
- One author → many books
  
⚙️ 6. application.properties (H2 example)

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
  

🧩 1. Author Entity (Author.java)

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    // Getters and Setters
}


🧩 2. Book Entity (Book.java)

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Getters and Setters
}


  📁 3. Repository Interfaces

// AuthorRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> { }

// BookRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }


🔧 4. Service Class (AuthorService.java)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void createAuthorWithBooks() 
    {
        Author author = new Author();
        author.setName("J.K. Rowling");

        Book book1 = new Book();
        book1.setTitle("Harry Potter and the Sorcerer's Stone");
        book1.setAuthor(author);

        Book book2 = new Book();
        book2.setTitle("Harry Potter and the Chamber of Secrets");
        book2.setAuthor(author);

        author.setBooks(Arrays.asList(book1, book2));

        authorRepository.save(author); // cascade saves books too
    }
}


🌐 5. Controller Class (AuthorController.java)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController 
{
    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    public String createAuthorWithBooks() 
    {
        authorService.createAuthorWithBooks();
        return "Author and books saved!";
    }
}

▶️ Run & Test:

POST: http://localhost:8080/authors/create

🖨️ Console Output:

Hibernate: insert into author (name) values (?)
Hibernate: insert into book (title, author_id) values (?, ?)
Hibernate: insert into book (title, author_id) values (?, ?)


✅ Summary:

- `@OneToMany(mappedBy = "author")` used in parent entity
- `@ManyToOne` used in child entity with a foreign key
- `cascade = CascadeType.ALL` ensures books are saved along with the author


  
🗄️ H2 Database Output (query using H2 console):

TABLE: AUTHOR
+----+---------------+
| ID | NAME          |
+----+---------------+
| 1  | J.K. Rowling  |
+----+---------------+

TABLE: BOOK
+----+----------------------------------------------+-----------+
| ID | TITLE                                        | AUTHOR_ID |
+----+----------------------------------------------+-----------+
| 1  | Harry Potter and the Sorcerer's Stone        |     1     |
| 2  | Harry Potter and the Chamber of Secrets      |     1     |
+----+----------------------------------------------+-----------+
  

