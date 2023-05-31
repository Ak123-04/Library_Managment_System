package com.example.Library.management.system.Repository;

import com.example.Library.management.system.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
