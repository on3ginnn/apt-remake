package com.aptproject.SpringLibraryProject.library.dto;

import com.aptproject.SpringLibraryProject.library.model.Book;
import com.aptproject.SpringLibraryProject.library.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class BookRentInfoDTO extends GenericDTO {

    private Long userId;
    private Long bookId;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private Integer rentPeriod;
    private boolean returned;
}
