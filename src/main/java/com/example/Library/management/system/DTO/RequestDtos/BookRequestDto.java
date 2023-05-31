package com.example.Library.management.system.DTO.RequestDtos;


import com.example.Library.management.system.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequestDto {

    private String bookName;

    private int authorId;
    private Genre genre;
    private int totalPages;
}
