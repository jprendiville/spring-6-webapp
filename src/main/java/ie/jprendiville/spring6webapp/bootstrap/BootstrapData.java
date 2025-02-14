package ie.jprendiville.spring6webapp.bootstrap;

import ie.jprendiville.spring6webapp.domain.Author;
import ie.jprendiville.spring6webapp.domain.Book;
import ie.jprendiville.spring6webapp.domain.Publisher;
import ie.jprendiville.spring6webapp.repositories.AuthorRepository;
import ie.jprendiville.spring6webapp.repositories.BookRepository;
import ie.jprendiville.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BootstrapData implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(BootstrapData.class);

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        bookRepository.deleteAll();
        publisherRepository.deleteAll();
        authorRepository.deleteAll();

        // *****************************************//
        // ************ ERIC EVANS *****************//
        // *****************************************//
        // Create an Author
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        // Create a Book
        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("1234567890");

        // Create a Publisher
        Publisher awPublisher = new Publisher();
        awPublisher.setName("Addison-Wesley");
        awPublisher.setAddress("10 Bank St");
        awPublisher.setCity("New York");
        awPublisher.setState("NY");
        awPublisher.setZip("10606");

        // Save the author, book and publisher
        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        Publisher awSaved = publisherRepository.save(awPublisher);

        // Save the Book to the Author and the Author to the Book
        ericSaved.getBooks().add(dddSaved);
        dddSaved.getAuthors().add(ericSaved);

        // Save the Book to the Publisher and the Publisher to the Book
        awSaved.getBooks().add(dddSaved);
        dddSaved.setPublisher(awSaved);

        // Save the author/book/publisher repositories
        authorRepository.save(ericSaved);
        bookRepository.save(dddSaved);
        publisherRepository.save(awPublisher);


        // *****************************************//
        // *********** ROD JOHNSON *****************//
        // *****************************************//

        // Create an Author
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        // Create two Books
        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("987654321");

        Book pjd = new Book();
        pjd.setTitle("Professional Java Development with the Spring Framework");
        pjd.setIsbn("543219876");

        // Create two Publishers
        Publisher wpPublisher = new Publisher();
        wpPublisher.setName("Wrox Press");
        wpPublisher.setAddress("111 River Street");
        wpPublisher.setCity("Hoboken");
        wpPublisher.setState("NJ");
        wpPublisher.setZip("07030");

        Publisher wtbpPublisher = new Publisher();
        wtbpPublisher.setName("Wrox the Box Press");
        wtbpPublisher.setAddress("222 Stream Street");
        wtbpPublisher.setCity("Nekoboh");
        wtbpPublisher.setState("JN");
        wtbpPublisher.setZip("03070");

        // Save the author, books and publishers
        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);
        Book pjdSaved = bookRepository.save(pjd);
        Publisher wpSaved = publisherRepository.save(wpPublisher);
        Publisher wtbpSaved = publisherRepository.save(wtbpPublisher);

        // Save the Book to the Author and the Author to the Book
        rodSaved.getBooks().add(noEJBSaved);
        rodSaved.getBooks().add(pjdSaved);
        noEJBSaved.getAuthors().add(rodSaved);
        pjdSaved.getAuthors().add(rodSaved);

        // Save the Book to the Publisher and the Publisher to the Book
        wpSaved.getBooks().add(noEJBSaved);
        wtbpSaved.getBooks().add(pjdSaved);
        noEJBSaved.setPublisher(wpSaved);
        pjdSaved.setPublisher(wtbpSaved);

        // Save the author/book/publisher repositories
        authorRepository.save(rodSaved);
        bookRepository.save(noEJBSaved);
        bookRepository.save(pjdSaved);
        publisherRepository.save(wpSaved);
        publisherRepository.save(wtbpSaved);

        logger.info("Author count: " + authorRepository.count());
        logger.info("Book count: " + bookRepository.count());
        logger.info("Publisher count: " + publisherRepository.count());

        for (Author author : authorRepository.findAll()) {
            for (Book book : author.getBooks()) {
                logger.info(author.getFullName() + " wrote '" + book.getTitle() + "', published by " + book.getPublisher().getName());
            }
        }

    }
}
