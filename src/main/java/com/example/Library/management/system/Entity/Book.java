package com.example.Library.management.system.Entity;

import com.example.Library.management.system.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int totalPages;

    private boolean issued;

    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    Card card;

//    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
//    List<Book>issuedBook=new ArrayList<>();

    @OneToMany(mappedBy = "book",cascade =CascadeType.ALL)
    List<Transaction> transactionList=new ArrayList<>();



}
