package com.example.Library.management.system.DTO.ResponseDtos;


import com.example.Library.management.system.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookResponseDto {

    private String name;

    private Genre genre;

    private int totalPages;

    private String authorName;
}
