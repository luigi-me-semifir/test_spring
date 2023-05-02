package com.example.gestiondatespring.repository;

import com.example.gestiondatespring.model.Payload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayloadRepository extends JpaRepository<Payload, Integer> {
}
