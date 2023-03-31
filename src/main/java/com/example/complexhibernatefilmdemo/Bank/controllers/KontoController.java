package com.example.complexhibernatefilmdemo.Bank.controllers;

import com.example.complexhibernatefilmdemo.Bank.models.Kategori;
import com.example.complexhibernatefilmdemo.Bank.models.Konto;
import com.example.complexhibernatefilmdemo.Bank.repos.KategoriRepo;
import com.example.complexhibernatefilmdemo.Bank.repos.KontoRepo;
import com.example.complexhibernatefilmdemo.Bank.repos.KundRepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class KontoController {

    private final KontoRepo kontoRepo;

    KontoController(KontoRepo kontoRepo){
        this.kontoRepo=kontoRepo;
    }

    @RequestMapping("konton")
    public List<Konto> getAllKonton(){
        return kontoRepo.findAll();
    }

    @RequestMapping("konton/delete/{id}")
    public String deleteKonto(@PathVariable Long id){
        kontoRepo.deleteById(id);
        return "konto togs bort";
    }

}
