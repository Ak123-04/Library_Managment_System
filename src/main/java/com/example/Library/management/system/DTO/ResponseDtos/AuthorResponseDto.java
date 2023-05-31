package com.example.Library.management.system.DTO.ResponseDtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorResponseDto {

    private String authorName;

    private int age;
    private String authorEmail;


}
