package com.md.courselibrary.controller;

import com.md.courselibrary.entity.Book;
import com.md.courselibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public String findAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("detail/{id}")
    public String findBookById(@PathVariable Long id, Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable Long id){
        Long bookId = bookService.findBookById(id).getId();
        bookService.deleteBook(bookId);
        return "redirect:/books/all";
    }

    @GetMapping("edit/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "update-book";
    }

    @PostMapping("/update")
    public String saveUpdatedBook(@ModelAttribute Book book) {
        Book existingBook = bookService.findBookById(book.getId());
        if (existingBook != null) {
            existingBook.setIsbn(book.getIsbn());
            existingBook.setName(book.getName());
            existingBook.setDescription(book.getDescription());
            bookService.saveBook(existingBook);
        }
        return "redirect:/books/all";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book, Model model) {
        Book existingBook = bookService.findBookByIsbn(book.getIsbn());
        if (existingBook != null) {
            model.addAttribute("error", "Book with ISBN " + book.getIsbn() + " already exists.");
            model.addAttribute("book", book);
            return "books"; // Return to the form with an error message
        }
        bookService.saveBook(book);
        return "redirect:/authors/add";
    }
}
