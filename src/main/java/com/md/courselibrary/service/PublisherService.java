package com.md.courselibrary.service;

import com.md.courselibrary.entity.Publisher;
import com.md.courselibrary.repository.BookRepository;
import com.md.courselibrary.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookService bookService;

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id) {
        return publisherRepository.findById(id).orElseThrow(()->
                new RuntimeException("Publisher not found with id: " + id));
    }

    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
        bookService.savingCompleteBook(publisher.getId());
    }

    public void deletePublisher(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()->
                new RuntimeException("Publisher not found with id: " + id));
        publisherRepository.deleteById(publisher.getId());
    }

    public Publisher updatePublisher(Long id, Publisher publisher) {
        Publisher existingPublisher = publisherRepository.findById(id).orElseThrow(()->
                new RuntimeException("Publisher not found with id: " + id));
        existingPublisher.setName(publisher.getName());
        return publisherRepository.save(existingPublisher);
    }

    public Publisher findPublisherByName(String name) {
        return publisherRepository.findPublisherByName(name);
    }
}
