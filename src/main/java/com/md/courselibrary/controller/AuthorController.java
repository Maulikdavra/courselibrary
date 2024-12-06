package com.md.courselibrary.controller;

import com.md.courselibrary.entity.Author;
import com.md.courselibrary.entity.Book;
import com.md.courselibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Show the form to add a new author
    @GetMapping("/add")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author()); // Provide an empty Author object for the form
        return "add-author";
    }

    // Handle saving a new author
    @PostMapping("/add")
    public void addAuthor(@ModelAttribute Author author) {
        Author existingAuthor = authorService.findAuthorByName(author.getName());
        if (existingAuthor == null) {
            // Save the new author
            authorService.saveAuthor(author);
        } else {
            // Optionally log or notify about duplicate authors
            System.out.println("Author already exists: " + author.getId());
        }
    }

    @GetMapping("/all")
    public String findAllAuthors(Model model) {
        List<Author> authors = authorService.findAllAuthors();
        model.addAttribute("authors", authors);
        return "authors"; // Show the authors.html page
    }

    @GetMapping("view/{id}")
    public String findAuthorById(@PathVariable Long id, Model model){
        Author author = authorService.findAuthorById(id);
        model.addAttribute("author", author);
        return "list-author";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id){
        Long authorId = authorService.findAuthorById(id).getId();
        authorService.deleteAuthor(authorId);
        return "redirect:/authors/all";
    }

    @GetMapping("/edit/{id}")
    public String updateAuthor(@PathVariable Long id, Model model) {
        Author author = authorService.findAuthorById(id);
        model.addAttribute("author", author);
        return "update-author";
    }

    @PostMapping("/update")
    public String saveUpdatedAuthor(@ModelAttribute Author author) {
        Author existingAuthor = authorService.findAuthorById(author.getId());
        if (existingAuthor != null) {
            existingAuthor.setName(author.getName());
            existingAuthor.setDescription(author.getDescription());
            authorService.saveAuthor(existingAuthor);
        }
        return "redirect:/authors/all";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute Author author, Model model) {
        Author existingAuthor = authorService.findAuthorByName(author.getName());
        if (existingAuthor != null) {
            model.addAttribute("error", "Author with name " + author.getName() + " already exists.");
            model.addAttribute("author", author);
            return "authors"; // Return to the form with an error message
        }
        authorService.saveAuthor(author);
        return "redirect:/category/add";
    }
}
