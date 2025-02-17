package ie.jprendiville.spring6webapp.repositories;

import ie.jprendiville.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
