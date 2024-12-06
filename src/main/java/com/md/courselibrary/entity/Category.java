package com.md.courselibrary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false, length = 50)
    private String name;

    @Column(name = "category_description", nullable = false, length = 100)
    private String description;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();
}
