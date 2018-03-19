package com.crud.library.controller;

import com.crud.library.domain.Status;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BorrowingDto;
import com.crud.library.domain.dto.ItemDto;
import com.crud.library.domain.dto.ReaderDto;
import com.crud.library.mapper.LibraryMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        dbService.saveReader(libraryMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        dbService.saveBook(libraryMapper.mapToBook(bookDto));

    }

    @RequestMapping(method = RequestMethod.POST, value = "createItem", consumes = APPLICATION_JSON_VALUE)
    public void createItem(@RequestBody ItemDto itemDto) {
        dbService.saveItem(libraryMapper.mapToItem(itemDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBorrowing", consumes = APPLICATION_JSON_VALUE)
    public void createBorrowing(@RequestBody BorrowingDto borrowingDto) {
        dbService.saveBorrowing(libraryMapper.mapToBorrowing(borrowingDto));
    }

    public ItemDto updateStatus (ItemDto itemDto, Status status) {
        itemDto.setStatus(status);
        return itemDto;
    }

    public BorrowingDto returnBook (BorrowingDto borrowingDto, boolean paidForDamaged){
        if(paidForDamaged) {
            borrowingDto.getItem().setStatus(Status.AVAILABLE);
        }
        borrowingDto.setBorrowedTo(new Date());
        return borrowingDto;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooksWithCondition")
    public List<BookDto> getBooksWithCondition() {
        return new ArrayList<>();
    }
}
