package com.example.complexhibernatefilmdemo.Bank.repos;

import com.example.complexhibernatefilmdemo.Bank.models.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;



public interface KpiRepo extends JpaRepository<Kpi, Long> {
}
