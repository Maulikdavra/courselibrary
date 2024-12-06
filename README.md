# Course Library - Springboot with Thymeleaf

This is a simple Springboot project integrated with Thymeleaf for managing a course library. The project includes several controllers to manage books, authors, categories, and publishers.

## Endpoints

### Book Controller
- **GET /books/all**: Fetches all books.
- **GET /books/detail/{id}**: Fetches details of a book by ID.
- **GET /books/delete/{id}**: Deletes a book by ID.
- **GET /books/edit/{id}**: Edits a book by ID.
- **POST /books/update**: Updates an existing book.
- **POST /books/save**: Saves a new book.

### Author Controller
- **GET /authors/add**: Shows the form to add a new author.
- **POST /authors/add**: Adds a new author.
- **GET /authors/all**: Fetches all authors.
- **GET /authors/view/{id}**: Fetches details of an author by ID.
- **GET /authors/delete/{id}**: Deletes an author by ID.
- **GET /authors/edit/{id}**: Edits an author by ID.
- **POST /authors/update**: Updates an existing author.
- **POST /authors/save**: Saves a new author.

### Category Controller
- **GET /category/add**: Shows the form to add a new category.
- **POST /category/add**: Adds a new category.
- **GET /category/all**: Fetches all categories.
- **GET /category/view/{id}**: Fetches details of a category by ID.
- **GET /category/delete/{id}**: Deletes a category by ID.
- **GET /category/edit/{id}**: Edits a category by ID.
- **POST /category/update**: Updates an existing category.
- **POST /category/save**: Saves a new category.

### Publisher Controller
- **GET /publishers/add**: Shows the form to add a new publisher.
- **POST /publishers/add**: Adds a new publisher.
- **GET /publishers/all**: Fetches all publishers.
- **GET /publishers/view/{id}**: Fetches details of a publisher by ID.
- **GET /publishers/delete/{id}**: Deletes a publisher by ID.
- **GET /publishers/edit/{id}**: Edits a publisher by ID.
- **POST /publishers/update**: Updates an existing publisher.
- **POST /publishers/save**: Saves a new publisher.

## Testing the Project

To test the project, start with the **"/books/all"** endpoint to fetch all books. Ensure that the Springboot application is running and then navigate to the endpoint using your browser or any API testing tool like Postman.

## How to Run

1. Clone the repository:
    ```sh
    git clone https://github.com/Maulikdavra/courselibrary.git
    ```
2. Navigate to the project directory:
    ```sh
    cd courselibrary
    ```
3. Run the application:
    ```sh
    ./mvnw spring-boot:run
    ```
4. Access the application at `http://localhost:8080/books/all`.

For more detailed information, view the [source code](https://github.com/Maulikdavra/courselibrary).

---

Note: This list may be incomplete; you can view more details in the [controller files](https://github.com/Maulikdavra/courselibrary/tree/main/src/main/java/com/md/courselibrary/controller).v
