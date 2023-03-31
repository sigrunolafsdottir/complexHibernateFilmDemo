package com.example.complexhibernatefilmdemo.Bank.repos;

import com.example.complexhibernatefilmdemo.Bank.models.Kategori;
import com.example.complexhibernatefilmdemo.Bank.models.Konto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KontoRepo extends JpaRepository<Konto, Long> {
}
