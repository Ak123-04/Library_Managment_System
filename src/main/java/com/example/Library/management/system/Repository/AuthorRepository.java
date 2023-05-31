package com.example.Library.management.system.Repository;

import com.example.Library.management.system.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    Author findByAuthorName(String name);
}
