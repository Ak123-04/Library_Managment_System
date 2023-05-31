package com.example.Library.management.system.Entity;


import com.example.Library.management.system.Enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//generating unique id number.
    private int id;

    private String name;

    private int age;

    private String mobNo;
    @Enumerated(EnumType.STRING)//converting enum type into string as sql dont have option to store enum type;
    private Department department;

    @OneToOne(mappedBy="student",cascade = CascadeType.ALL)
    Card card;
}
