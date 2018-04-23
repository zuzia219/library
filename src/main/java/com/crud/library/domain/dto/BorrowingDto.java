package com.crud.library.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDto {

    private Long readerId;
    private Long itemId;
    private Long borrowingId;
    private boolean paidForDamaged;
}
