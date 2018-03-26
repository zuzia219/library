package com.crud.library.domain.dto;


import com.crud.library.domain.Item;
import com.crud.library.domain.Reader;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDto {

    private Long id;
    private Item item;
    private Reader reader;
    private Date borrowedFrom;
    private Date borrowedTo;
    private boolean paidForDamaged;

    public BorrowingDto(Item item, Reader reader) {
        this.item = item;
        this.reader = reader;
        this.borrowedFrom = new Date();
        this.borrowedTo = null;
        this.paidForDamaged = false;
    }
}
