package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "READERS")
public class Reader {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "reader")
    private List<Borrowing> readersBorrowings = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "FAMILYNAME")
    private String familyname;

    @Column(name = "ACCOUNT_CREATED")
    private Date accountCreated;

    public Reader(String name, String familyname) {
        this.name = name;
        this.familyname = familyname;
        this.accountCreated = new Date();
    }
}
