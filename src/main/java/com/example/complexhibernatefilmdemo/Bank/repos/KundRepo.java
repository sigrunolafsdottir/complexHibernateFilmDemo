package com.example.complexhibernatefilmdemo.Bank.repos;

import com.example.complexhibernatefilmdemo.Bank.models.Kund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundRepo extends JpaRepository<Kund, Long> {
}
