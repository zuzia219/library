package com.crud.library.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/*@NamedQuery(
        name = "Item.getNumberOfBookItemsByTitle",
        query = "from Item where book.getTitle= :title, count(all)"
)*/

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ITEMS")
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
