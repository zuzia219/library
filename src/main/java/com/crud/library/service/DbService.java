package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.Borrowing;
import com.crud.library.domain.Item;
import com.crud.library.domain.Reader;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.BorrowingRepository;
import com.crud.library.repository.ItemRepository;
import com.crud.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Item saveItem(final Item item) {
        return itemRepository.save(item);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public Borrowing saveBorrowing(final Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }
}
