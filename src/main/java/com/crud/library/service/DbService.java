package com.crud.library.service;

import com.crud.library.domain.*;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BorrowingDto;
import com.crud.library.domain.dto.ItemDto;
import com.crud.library.domain.dto.ReaderDto;
import com.crud.library.mapper.LibraryMapper;
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
    @Autowired
    private LibraryMapper libraryMapper;

    public BookDto saveBook(final BookDto bookDto) {
        Book book = libraryMapper.mapToBook(bookDto);
        bookRepository.save(book);
        return libraryMapper.mapToBookDto(book);
    }

    public ReaderDto saveReader(final ReaderDto readerDto) {
        Reader reader = libraryMapper.mapToReader(readerDto);
        reader.setAccountCreated(new Date());
        readerRepository.save(reader);
        return libraryMapper.mapToReaderDto(reader);
    }

    public ItemDto saveItem(final ItemDto itemDto) {
        Book book = getBookById(itemDto.getBookId());
        Item item = new Item(book);
        itemRepository.save(item);
        return libraryMapper.mapToItemDto(item);
    }

    public ItemDto updateSatus(final ItemDto itemDto) {
        Item item = getItemById(itemDto.getItemId());
        Book book = item.getBook();
        Status status = itemDto.getStatus();
        item.setStatus(status);
        item.setBook(book);
        itemRepository.save(item);
        return libraryMapper.mapToItemDto(item);
    }

    public BorrowingDto saveBorrowing(final BorrowingDto borrowingDto) {
        Reader reader = getReaderById(borrowingDto.getReaderId());
        Item item = getItemById(borrowingDto.getItemId());
        Borrowing borrowing = new Borrowing(item, reader);
        borrowing.setBorrowedFrom(new Date());
        borrowingRepository.save(borrowing);
        return libraryMapper.mapToBorrowingDto(borrowing);
    }

    public BorrowingDto returnBook(final BorrowingDto borrowingDto) {
        Borrowing borrowing = getBorrowingById(borrowingDto.getBorrowingId());
        borrowing.setBorrowedTo(new Date());
        if (borrowingDto.isPaidForDamaged()) {
            borrowing.getItem().setStatus(Status.AVAILABLE);
            borrowing.setPaidForDamaged(true);
        }
        borrowingRepository.save(borrowing);
        return libraryMapper.mapToBorrowingDto(borrowing);
    }

    public Long getNumberOfItemsByTitle(String title) {
        return itemRepository.getNumberOfBookItemsByTitle(title);
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

    public Borrowing getBorrowingById(final Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }
}
