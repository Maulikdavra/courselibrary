package com.md.courselibrary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", nullable = false, length = 50, unique = true)
    private String isbn;

    @Column(name = "book_name", nullable = false, length = 50)
    private String name;

    @Column(name = "book_description", nullable = false, length = 300)
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"), // primary key of book table
            inverseJoinColumns = @JoinColumn(name = "author_id")) // foreign key of author table
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"), // primary key of book table
            inverseJoinColumns = @JoinColumn(name = "category_id")) // foreign key of author table
    private Set<Category> categories = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_publishers",
            joinColumns = @JoinColumn(name = "book_id"), // primary key of book table
            inverseJoinColumns = @JoinColumn(name = "publisher_id")) // foreign key of author table
    private Set<Publisher> publishers = new HashSet<>();

    // Here we are removing bidirectional relationship, removing publisher will also remove books from publisher
    public void removePublisher(Publisher publisher) {
        this.publishers.remove(publisher);
        publisher.getBooks().remove(publisher);
    }

    // Here we are adding bidirectional relationship, adding publisher will also add books to publisher
    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }

    // Here we are removing bidirectional relationship, removing author will also remove books from author
    public void removeAuthor(Author author) {
        this.authors.remove(author);
        author.getBooks().remove(author);
    }

    // Here we are adding bidirectional relationship, adding author will also add books to author
    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }

    // Here we are removing bidirectional relationship, removing category will also remove books from category
    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.getBooks().remove(category);
    }

    // Here we are adding bidirectional relationship, adding category will also add books to category
    public void addCategory(Category category) {
        this.categories.add(category);
        category.getBooks().add(this);
    }
}
