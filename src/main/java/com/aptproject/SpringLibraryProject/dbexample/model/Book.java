package com.aptproject.SpringLibraryProject.dbexample.model;

import lombok.*;

import java.util.Date;

// POJO - plain old Java object
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Date dateAdded;
}
