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


@Component
public class LibraryMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPublicationYear());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(book.getTitle(), book.getAuthor(), book.getPublicationYear());
    }

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(readerDto.getName(), readerDto.getFamilyname());
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(reader.getName(), reader.getFamilyname(), reader.getAccountCreated());
    }

    public ItemDto mapToItemDto(final Item item) {
        return new ItemDto(item.getBook().getId(), item.getItemId(), item.getStatus());
    }

    public BorrowingDto mapToBorrowingDto(final Borrowing borrowing) {
        return new BorrowingDto(borrowing.getReader().getId(), borrowing.getItem().getItemId(), borrowing.getId(), borrowing.isPaidForDamaged());
    }
}
