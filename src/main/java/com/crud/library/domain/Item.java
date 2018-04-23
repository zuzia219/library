package com.crud.library.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ITEMS")

@NamedNativeQuery(
        name = "Item.getNumberOfBookItemsByTitle",
        query = "SELECT count(*) from books, items where books.id = items.book_id and title = :TITLE"
)
public class Item {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long itemId;

    @Enumerated
    @Column(name = "STATUS")
    private Status status;

    public Item(Book book) {
        this.book = book;
        this.status = Status.AVAILABLE;
    }
}
