package com.md.courselibrary.service;

import com.md.courselibrary.entity.Author;
import com.md.courselibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(()->
                new RuntimeException("Author not found with id: " + id));
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->
                new RuntimeException("Author not found with id: " + id));
        authorRepository.deleteById(author.getId());
    }

    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = authorRepository.findById(id).orElseThrow(()->
                new RuntimeException("Author not found with id: " + id));
        existingAuthor.setName(author.getName());
        existingAuthor.setDescription(author.getDescription());
        return authorRepository.save(existingAuthor);
    }

    public Author findAuthorByName(String name) {
        return authorRepository.findByName(name);
    }
}
