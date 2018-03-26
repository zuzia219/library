package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BORROWINGS")
public class Borrowing {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Reader.class)
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @Column(name = "BORROWED_FROM")
    @NotNull
    private Date borrowedFrom;

    @Column(name = "BORROWED_TO")
    private Date borrowedTo;

    @Column(name = "PAID_FOR_DAMAGED")
    private boolean paidForDamaged;

    public Borrowing(Item item, Reader reader) {
        this.item = item;
        this.reader = reader;
        this.borrowedFrom = new Date();
        this.borrowedTo = null;
        this.paidForDamaged = false;
    }
}

