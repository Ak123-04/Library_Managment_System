package com.example.Library.management.system.DTO.RequestDtos;


import com.example.Library.management.system.Enums.Department;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentRequestDto {

    private String name;

    private int age;

    private String mobNo;

    private Department department;
}
