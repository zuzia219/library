package com.crud.library.controller;

import com.crud.library.domain.Status;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BorrowingDto;
import com.crud.library.domain.dto.ItemDto;
import com.crud.library.domain.dto.ReaderDto;
import com.crud.library.mapper.LibraryMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("v1/library")
public class LibraryController {

    @Autowired
    DbService dbService;
    @Autowired
    LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        readerDto.setAccountCreated(new Date());
        dbService.saveReader(libraryMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        dbService.saveBook(libraryMapper.mapToBook(bookDto));

    }

    @RequestMapping(method = RequestMethod.POST, value = "createItem", consumes = APPLICATION_JSON_VALUE)
    public void createItem(@RequestBody ItemDto itemDto) {
        itemDto.setStatus(Status.AVAILABLE);
        dbService.saveItem(libraryMapper.mapToItem(itemDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBorrowing", consumes = APPLICATION_JSON_VALUE)
    public void createBorrowing(@RequestBody BorrowingDto borrowingDto) {
        borrowingDto.setBorrowedFrom(new Date());
        borrowingDto.setPaidForDamaged(false);
        dbService.saveBorrowing(libraryMapper.mapToBorrowing(borrowingDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateStatus")
    public ItemDto updateStatus(@RequestBody ItemDto itemDto) {
        return libraryMapper.mapToItemDto(dbService.saveItem(libraryMapper.mapToItem(itemDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public BorrowingDto returnBook(BorrowingDto borrowingDto) {
/*        if(borrowingDto.isPaidForDamaged()) {
            borrowingDto.getItem().setStatus(Status.AVAILABLE);
        }
        borrowingDto.setBorrowedTo(new Date());*/
        return libraryMapper.mapToBorrowingDto(dbService.saveBorrowing(libraryMapper.mapToBorrowing(borrowingDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooksWithCondition")
    public List<BookDto> getBooksWithCondition() {
        return new ArrayList<>();
    }
}
