package ie.jprendiville.spring6webapp.services;

import ie.jprendiville.spring6webapp.domain.Publisher;

public interface PublisherService {

    Iterable<Publisher> findAll();

}
