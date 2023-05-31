package com.example.Library.management.system.DTO.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorRequestDto {

    private String authorName;

    private int authorAge;

    private String authorEmail;

}
