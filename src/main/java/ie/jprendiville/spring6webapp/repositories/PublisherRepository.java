package ie.jprendiville.spring6webapp.repositories;

import ie.jprendiville.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
