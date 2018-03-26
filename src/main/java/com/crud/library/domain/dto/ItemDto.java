package com.crud.library.domain.dto;

import com.crud.library.domain.Book;
import com.crud.library.domain.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Book book;
    private Long itemId;
    private Status status;

    public ItemDto(Book book) {
        this.book = book;
        this.status = Status.AVAILABLE;
    }
}
