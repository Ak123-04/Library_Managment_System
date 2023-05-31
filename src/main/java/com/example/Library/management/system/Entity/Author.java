package com.example.Library.management.system.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="author")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String authorName;

    private int authorAge;

    @Column(unique = true)//using this annotation it will take unique email id of every new author
    private String authorEmail;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book>bookList=new ArrayList<>();

}
