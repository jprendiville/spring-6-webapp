package ie.jprendiville.spring6webapp.repositories;

import ie.jprendiville.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
