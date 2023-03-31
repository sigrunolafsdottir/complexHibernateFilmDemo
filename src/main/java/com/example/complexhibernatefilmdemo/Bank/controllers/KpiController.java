package com.example.complexhibernatefilmdemo.Bank.controllers;


import com.example.complexhibernatefilmdemo.Bank.models.Kpi;
import com.example.complexhibernatefilmdemo.Bank.repos.KpiRepo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KpiController {

    private final KpiRepo repo;

    KpiController(KpiRepo repo){
        this.repo=repo;
    }

    @RequestMapping("kpis")
    public List<Kpi> getAllKPIs(){
        return repo.findAll();
    }

    @RequestMapping("kpi/add")
    public String addKPIs(@RequestParam int cred){
        repo.save(new Kpi(cred));
        return "kpi "+cred+" added";
    }


}
