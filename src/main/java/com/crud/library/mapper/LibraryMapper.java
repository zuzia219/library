package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.Borrowing;
import com.crud.library.domain.Item;
import com.crud.library.domain.Reader;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BorrowingDto;
import com.crud.library.domain.dto.ItemDto;
import com.crud.library.domain.dto.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryMapper {

    public Book mapToBook(final BookDto bookDto) {
        List<Item> items = bookDto.getItems().stream()
                .map(t -> new Item(t.getBook(), t.getItemId(), t.getStatus()))
                .collect(Collectors.toList());
        return new Book(items, bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPublicationYear());
    }

    public Reader mapToReader(final ReaderDto readerDto) {
        List<Borrowing> borrowings = readerDto.getReadersBorrowings().stream()
                .map(t -> new Borrowing(t.getId(), t.getItem(), t.getReader(), t.getBorrowedFrom(), t.getBorrowedTo(), t.isPaidForDamaged()))
                .collect(Collectors.toList());
        return new Reader(borrowings, readerDto.getId(), readerDto.getName(), readerDto.getFamilyname(), readerDto.getAccountCreated());
    }
}
