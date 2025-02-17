package ie.jprendiville.spring6webapp.services;

import ie.jprendiville.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
