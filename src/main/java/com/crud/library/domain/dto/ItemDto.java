package com.crud.library.domain.dto;

import com.crud.library.domain.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {
    private Long bookId;
    private Long itemId;
    private Status status;
}
