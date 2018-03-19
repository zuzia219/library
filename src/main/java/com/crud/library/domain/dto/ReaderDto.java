package com.crud.library.domain.dto;


import com.crud.library.domain.Borrowing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDto {
    private List<Borrowing> readersBorrowings = new ArrayList<>();
    private Long id;
    private String name;
    private String familyname;
    private Date accountCreated;

    public ReaderDto(String name, String familyname) {
        this.name = name;
        this.familyname = familyname;
        this.accountCreated = new Date();
    }

}
