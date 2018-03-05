package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ITEMS")
public class Item {
    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long itemId;

    @NotNull
    @Column(name = "STATUS")
    private Status status;
}
