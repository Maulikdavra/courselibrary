INSERT INTO authors (author_name, author_description) VALUES
('Author 1', 'Description for Author 1'),
('Author 2', 'Description for Author 2'),
('Author 3', 'Description for Author 3'),
('Author 4', 'Description for Author 4'),
('Author 5', 'Description for Author 5');

INSERT INTO categories (category_name, category_description) VALUES
('Category 1', 'Description for Category 1'),
('Category 2', 'Description for Category 2'),
('Category 3', 'Description for Category 3'),
('Category 4', 'Description for Category 4'),
('Category 5', 'Description for Category 5');

INSERT INTO publishers (publisher_name) VALUES
('Publisher 1'),
('Publisher 2'),
('Publisher 3'),
('Publisher 4'),
('Publisher 5');

INSERT INTO books (isbn, book_name, book_description) VALUES
('ISBN-001', 'Book 1', 'Description for Book 1'),
('ISBN-002', 'Book 2', 'Description for Book 2'),
('ISBN-003', 'Book 3', 'Description for Book 3'),
('ISBN-004', 'Book 4', 'Description for Book 4'),
('ISBN-005', 'Book 5', 'Description for Book 5');

INSERT INTO book_authors (book_id, author_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO book_categories (book_id, category_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO book_publishers (book_id, publisher_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);