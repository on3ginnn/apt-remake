package com.aptproject.SpringLibraryProject.library.controller.rest;

import com.aptproject.SpringLibraryProject.library.dto.BookDTO;
import com.aptproject.SpringLibraryProject.library.model.Book;
import com.aptproject.SpringLibraryProject.library.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books") // http://localhost:8080/books
@Tag(name = "Книги", description = "Контроллер для работы с книгами из библиотеки")
public class BookController extends GenericController<Book, BookDTO> {

    protected BookController(BookService bookService) {
        super(bookService);
    }

    @Operation(description = "Добавить автора к книге")
    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> addAuthor(@RequestParam(value = "bookId") Long bookId,
                                          @RequestParam(value = "authorId") Long authorId) {
        return ResponseEntity.status(HttpStatus.OK).
                body(((BookService) service).addAuthor(bookId, authorId));
    }
}
