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

    public Item mapToItem (final ItemDto itemDto) {
        return new Item(itemDto.getBook(), itemDto.getItemId(), itemDto.getStatus());
    }

    public ItemDto mapToItemDto (final Item item) {
        return new ItemDto(item.getBook(), item.getItemId(), item.getStatus());
    }

    public Book mapToBook (final BookDto bookDto) {
        List<Item> items = bookDto.getItems().stream()
                .map(t -> new Item(t.getBook(), t.getItemId(), t.getStatus()))
                .collect(Collectors.toList());
        return new Book(items, bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPublicationYear());
    }

    public BookDto mapToBookDto (final Book book) {
        List<Item> items = book.getItems().stream()
                .map(t -> new Item(t.getBook(), t.getItemId(), t.getStatus()))
                .collect(Collectors.toList());
        return new BookDto(items, book.getId(), book.getTitle(), book.getAuthor(), book.getPublicationYear());
    }

    public Borrowing mapToBorrowing (final BorrowingDto borrowingDto) {
        return new Borrowing (borrowingDto.getId(),borrowingDto.getItem(), borrowingDto.getReader(), borrowingDto.getBorrowedFrom(), borrowingDto.getBorrowedTo());
    }

    public BorrowingDto mapToBorrowingDto (final Borrowing borrowing) {
        return new BorrowingDto (borrowing.getId(),borrowing.getItem(), borrowing.getReader(), borrowing.getBorrowedFrom(), borrowing.getBorrowedTo());
    }

    public Reader mapToReader (final ReaderDto readerDto) {
        List<Borrowing> borrowings = readerDto.getReadersBorrowings().stream()
                .map(t -> new Borrowing(t.getId(), t.getItem(), t.getReader(), t.getBorrowedFrom(), t.getBorrowedTo()))
                .collect(Collectors.toList());
        return new Reader(borrowings, readerDto.getId(), readerDto.getName(), readerDto.getFamilyname(), readerDto.getAccountCreated());
    }

    public ReaderDto mapToReaderDto (final Reader reader) {
        List<Borrowing> borrowings = reader.getReadersBorrowings().stream()
                .map(t -> new Borrowing(t.getId(), t.getItem(), t.getReader(), t.getBorrowedFrom(), t.getBorrowedTo()))
                .collect(Collectors.toList());
        return new ReaderDto(borrowings, reader.getId(), reader.getName(), reader.getFamilyname(), reader.getAccountCreated());
    }

}
