CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(50) NOT NULL UNIQUE,
    author_description VARCHAR(300) NOT NULL
);

CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL UNIQUE,
    category_description VARCHAR(300) NOT NULL
);

CREATE TABLE publishers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    publisher_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(50) NOT NULL UNIQUE,
    book_name VARCHAR(50) NOT NULL,
    book_description VARCHAR(300) NOT NULL
);

CREATE TABLE book_authors (
    book_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

CREATE TABLE book_categories (
    book_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, category_id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE book_publishers (
    book_id BIGINT NOT NULL,
    publisher_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, publisher_id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (publisher_id) REFERENCES publishers(id)
);