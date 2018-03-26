package com.crud.library.repository;

import com.crud.library.domain.Book;
import com.crud.library.domain.Borrowing;
import com.crud.library.domain.Item;
import com.crud.library.domain.Reader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTestSuite {


    @Autowired
    BorrowingRepository borrowingRepository;

    @Autowired
    ReaderRepository readerRepository;


    @Test
    public void testBorrowingRepository() {

        //Given
        Book book1 = new Book("book title", "book author", 1856);
        Book book2 = new Book("book title 2", "book author 2", 1956);
        Item item1 = new Item(book1);
        Item item2 = new Item(book2);
        Reader reader = new Reader("Andrew", "Andrewoski");
        Borrowing borrowing1 = new Borrowing(item1, reader);
        Borrowing borrowing2 = new Borrowing(item2, reader);
        reader.getReadersBorrowings().add(borrowing1);
        reader.getReadersBorrowings().add(borrowing2);

        //When
        borrowingRepository.save(borrowing1);
        long id1 = borrowing1.getId();
        borrowingRepository.save(borrowing2);
        long id2 = borrowing2.getId();

        //Then
        Assert.assertNotEquals(0, id1);
        Assert.assertNotEquals(0, id2);


        //Cleanup
        borrowingRepository.delete(borrowing1);
        borrowingRepository.delete(borrowing2);

    }
}
