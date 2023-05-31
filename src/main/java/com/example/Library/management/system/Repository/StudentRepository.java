package com.example.Library.management.system.Repository;

import com.example.Library.management.system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    String deleteById(int id);
}
