package com.md.courselibrary.service;

import com.md.courselibrary.entity.Author;
import com.md.courselibrary.entity.Book;
import com.md.courselibrary.entity.Category;
import com.md.courselibrary.entity.Publisher;
import com.md.courselibrary.repository.AuthorRepository;
import com.md.courselibrary.repository.BookRepository;
import com.md.courselibrary.repository.CategoryRepository;
import com.md.courselibrary.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(()->
                new RuntimeException("Book not found with id: " + id));
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->
                new RuntimeException("Book not found with id: " + id));
        bookRepository.deleteById(book.getId());
    }

    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public void savingCompleteBook(Long id) {

        Book book = findBookById(id);

        Author author = authorRepository.findById(id).orElseThrow();
        book.addAuthor(author);

        Category category = categoryRepository.findById(id).orElseThrow();
        book.addCategory(category);

        Publisher publisher = publisherRepository.findById(id).orElseThrow();
        book.addPublisher(publisher);

        bookRepository.save(book);
    }

}
