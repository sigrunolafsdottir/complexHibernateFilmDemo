package com.example.complexhibernatefilmdemo.Bank.repos;

import com.example.complexhibernatefilmdemo.Bank.models.Kategori;
import com.example.complexhibernatefilmdemo.Bank.models.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KategoriRepo extends JpaRepository<Kategori, Long> {
}
