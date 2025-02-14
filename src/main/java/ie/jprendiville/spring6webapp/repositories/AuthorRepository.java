package ie.jprendiville.spring6webapp.repositories;

import ie.jprendiville.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findAll();
}
