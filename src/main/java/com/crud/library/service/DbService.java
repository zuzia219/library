package com.crud.library.service;

import com.crud.library.domain.*;
import com.crud.library.domain.dto.BorrowingDto;
import com.crud.library.domain.dto.ItemDto;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.BorrowingRepository;
import com.crud.library.repository.ItemRepository;
import com.crud.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DbService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private BorrowingRepository borrowingRepository;

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public Reader saveReader(final Reader reader) {
        reader.setAccountCreated(new Date());
        return readerRepository.save(reader);
    }

    public Item saveItem(final ItemDto itemDto) {
        Book book = getBookById(itemDto.getBookId());
        Item item = new Item(book);
        return itemRepository.save(item);
    }

    public Item updateSatus(final ItemDto itemDto) {
        Item item = getItemById(itemDto.getItemId());
        Book book = item.getBook();
        Status status = itemDto.getStatus();
        item.setStatus(status);
        item.setBook(book);
        return itemRepository.save(item);
    }

    public Borrowing saveBorrowing(final BorrowingDto borrowingDto) {
        Reader reader = getReaderById(borrowingDto.getReaderId());
        Item item = getItemById(borrowingDto.getItemId());
        Borrowing borrowing = new Borrowing(item, reader);
        borrowing.setBorrowedFrom(new Date());
        return borrowingRepository.save(borrowing);
    }

    public Borrowing returnBook(final BorrowingDto borrowingDto) {
        Borrowing borrowing = getBorowingById(borrowingDto.getBorrowingId());
        borrowing.setBorrowedTo(new Date());
        if (borrowingDto.isPaidForDamaged()) {
            borrowing.getItem().setStatus(Status.AVAILABLE);
            borrowing.setPaidForDamaged(true);
        }
        return borrowingRepository.save(borrowing);
    }

    public Book getBookById(final Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Reader getReaderById(final Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public Item getItemById(final Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Borrowing getBorowingById(final Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }
}
