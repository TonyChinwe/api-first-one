package com.phisoft.apifirstone.controllers;

import com.phisoft.apifirstone.api.StoreApi;
import com.phisoft.apifirstone.error.BookNotFoundException;
import com.phisoft.apifirstone.models.*;
import com.phisoft.apifirstone.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController implements StoreApi {
    private final Logger logger= LoggerFactory.getLogger(BookController.class);
    private AuthorService authorService;
    private CategoryService categoryService;
    private PublisherService publisherService;
    private BookTypeService bookTypeService;
    private BookService bookService;

    public BookController(@Qualifier("author-impl-one") AuthorService authorService,
                         @Qualifier("category-impl-one") CategoryService categoryService,
                         @Qualifier("publisher-impl-one") PublisherService publisherService,
                         @Qualifier("book-type-impl-one") BookTypeService bookTypeService,
                          @Qualifier("book-impl-one") BookService bookService){
       this.authorService=authorService;
       this.categoryService=categoryService;
       this.publisherService=publisherService;
       this.bookTypeService=bookTypeService;
       this.bookService=bookService;


   }
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<Author>> getAllAuthors() {
        logger.info("Inside the book controller in the get-all-book-authors method fetching all the author registered in our book store");
        return ResponseEntity.ok(authorService.findAllAuthors());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<Category>> getAllBookCategories() {
        logger.info("Inside the book controller in the get-all-book-category method fetching all the book categories registered in our book store");
        return ResponseEntity.ok(categoryService.findAllBookCategory());

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<Publisher>> getAllBookPublishers() {
        logger.info("Inside the book controller in the get-all-book-publisher method fetching all the book publisher registered in our book store");
        return ResponseEntity.ok(publisherService.findAllBookPublisher());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<BookType>> getAllBookTypes() {
        logger.info("Inside the book controller in the get-all-book-type method fetching all the book types registered in our book store");
        return ResponseEntity.ok(bookTypeService.findAllBookTypes());


    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BooksResponse> getAllBooks(@Valid Integer page, @Valid Long size, @Valid String sortField, @Valid String sortDirection) {
        logger.info("Inside the book controller in the get-all-books method fetching all the book uploaded to our book store");
        return ResponseEntity.ok(bookService.allBooks(page,Integer.valueOf(size+""),sortField,sortDirection));

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public BooksResponse getBookByAuthor(String name) {
        logger.info("Inside the book controller in the get-all-book-by-author method fetching all the book belonging to a particular author");
        return bookService.getBookByAuthor(name);

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BookResponseDto> getBookById(Long bookId) throws BookNotFoundException {
        logger.info("Inside the book controller in the get-book-by-id method fetching the book with a particular id");
        return ResponseEntity.ok(bookService.getBookById(bookId));

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public BookResponseDto getBookByTitle(String title) {
        logger.info("Inside the book controller in the get-book-by-title method fetching the book with a particular title");
        return bookService.getBookByTitle(title);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public BookDto saveBook(@Valid BookDto body) {
        logger.info("Inside the book controller in the save-book method saving book to our book store");
        return bookService.saveBook(body);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BookResponseDto updateBook(@Valid UpdateBookDto body, Long bookId) {
        logger.info("Inside the book controller in the update-book method updating a book with a particular id");
        return (BookResponseDto) bookService.updateBook(body,bookId);

    }
}
