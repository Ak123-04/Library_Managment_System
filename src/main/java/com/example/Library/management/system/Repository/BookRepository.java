package com.example.Library.management.system.Repository;

import com.example.Library.management.system.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
