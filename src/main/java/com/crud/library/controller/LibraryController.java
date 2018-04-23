package com.crud.library.controller;


import com.crud.library.domain.Book;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BorrowingDto;
import com.crud.library.domain.dto.ItemDto;
import com.crud.library.domain.dto.ReaderDto;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.ItemRepository;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/library")
public class LibraryController {

    @Autowired
    DbService dbService;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return dbService.saveReader(readerDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return dbService.saveBook(bookDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createItem", consumes = APPLICATION_JSON_VALUE)
    public ItemDto createItem(@RequestBody ItemDto itemDto) {
        return dbService.saveItem(itemDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBorrowing", consumes = APPLICATION_JSON_VALUE)
    public BorrowingDto createBorrowing(@RequestBody BorrowingDto borrowingDto) {
        return dbService.saveBorrowing(borrowingDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateStatus")
    public ItemDto updateStatus(@RequestBody ItemDto itemDto) {
        return dbService.updateSatus(itemDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public BorrowingDto returnBook(@RequestBody BorrowingDto borrowingDto) {
        return dbService.returnBook(borrowingDto);
    }
    @RequestMapping(method = RequestMethod.GET, value = "getNumberOfItemsByTitle")
    public Long getNumberOfItemsByTitle(@RequestParam String title) {
        return itemRepository.getNumberOfBookItemsByTitle(title);
    }
}
