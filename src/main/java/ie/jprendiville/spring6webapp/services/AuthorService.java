package ie.jprendiville.spring6webapp.services;

import ie.jprendiville.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();

}
