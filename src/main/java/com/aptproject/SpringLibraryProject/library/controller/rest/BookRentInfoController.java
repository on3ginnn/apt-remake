package com.aptproject.SpringLibraryProject.library.controller.rest;

import com.aptproject.SpringLibraryProject.library.dto.BookRentInfoDTO;
import com.aptproject.SpringLibraryProject.library.model.BookRentInfo;
import com.aptproject.SpringLibraryProject.library.service.BookRentInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent/info")
@Tag(name = "Контроллер для работы с арендами книг")
public class BookRentInfoController extends GenericController<BookRentInfo, BookRentInfoDTO> {
    public BookRentInfoController(BookRentInfoService bookRentInfoService) {
        super(bookRentInfoService);
    }
}
