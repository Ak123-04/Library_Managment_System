package com.example.Library.management.system.DTO.ResponseDtos;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponseDto {

    private int id;
    private String name;

    private String message;

    private CardResponseDto cardResponseDto;
}
