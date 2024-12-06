package com.md.courselibrary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author_name", nullable = false, length = 50, unique = true)
    private String name;

    @Column(name = "author_description", nullable = false, length = 300)
    private String description;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();
}
