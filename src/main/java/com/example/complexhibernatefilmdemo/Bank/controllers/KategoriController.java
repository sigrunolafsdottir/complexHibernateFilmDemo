package com.example.complexhibernatefilmdemo.Bank.controllers;

import com.example.complexhibernatefilmdemo.Bank.models.Kategori;
import com.example.complexhibernatefilmdemo.Bank.models.Kpi;
import com.example.complexhibernatefilmdemo.Bank.models.Kund;
import com.example.complexhibernatefilmdemo.Bank.repos.KategoriRepo;
import com.example.complexhibernatefilmdemo.Bank.repos.KpiRepo;
import com.example.complexhibernatefilmdemo.Bank.repos.KundRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class KategoriController {


    private final KategoriRepo kategoriRepo;
    private final KundRepo kundRepo;

    KategoriController(KategoriRepo kategoriRepo, KundRepo kundRepo){
        this.kategoriRepo=kategoriRepo;
        this.kundRepo=kundRepo;
    }

    @RequestMapping("kategorier/add")
    public String addKategori(@RequestParam String namn) {
        kategoriRepo.save(new Kategori(namn));
        return "Kategori "+namn+" lades till";
    }

    @RequestMapping("kategorier/delete/{id}")
    public String deleteKategori(@PathVariable Long id){
        kategoriRepo.deleteById(id);
        return "kategori "+id+" togs bort";
    }

    @RequestMapping("kategori")
    public Kategori getKategoriById(@RequestParam Long id) {
        return kategoriRepo.findById(id).orElse(null);
    }

    @RequestMapping("kategorier")
    public List<Kategori> getAllKategorier(){
        return kategoriRepo.findAll();
    }

    @PostMapping("/kategorier/addByPost")
    public String addBookByPOST(@RequestBody Kategori k){
        kategoriRepo.save(k);
        return "Kategori "+k.getName()+" lades till";
    }



}
