package com.crud.library.domain.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {
    private String title;
    private String author;
    private int publicationYear;

    public BookDto(String tiltle, String author, int publicationYear) {
        this.title = tiltle;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}