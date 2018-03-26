package com.crud.library.domain.dto;

import com.crud.library.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private List<Item> items = new ArrayList<>();
    private Long id;
    private String title;
    private String author;
    private int publicationYear;

    public BookDto(String tiltle, String author, int publicationYear) {
        this.title = tiltle;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}