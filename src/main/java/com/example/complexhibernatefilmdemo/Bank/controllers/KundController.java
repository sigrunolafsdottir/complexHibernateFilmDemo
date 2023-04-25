package com.example.complexhibernatefilmdemo.Bank.controllers;

import com.example.complexhibernatefilmdemo.Bank.models.Kategori;
import com.example.complexhibernatefilmdemo.Bank.models.Konto;
import com.example.complexhibernatefilmdemo.Bank.models.Kpi;
import com.example.complexhibernatefilmdemo.Bank.models.Kund;
import com.example.complexhibernatefilmdemo.Bank.repos.KategoriRepo;
import com.example.complexhibernatefilmdemo.Bank.repos.KontoRepo;
import com.example.complexhibernatefilmdemo.Bank.repos.KpiRepo;
import com.example.complexhibernatefilmdemo.Bank.repos.KundRepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class KundController {


    private final KpiRepo repo;
    private final KundRepo kundRepo;
    private final KontoRepo kontoRepo;

    private final KategoriRepo katRepo;

    KundController(KpiRepo repo, KundRepo kundRepo, KategoriRepo katRepo, KontoRepo kontoRepo){
        this.repo=repo;
        this.kundRepo=kundRepo;
        this.katRepo=katRepo;
        this.kontoRepo=kontoRepo;
    }

    @RequestMapping("kunder")
    public List<Kund> getAllKunder(){
        return kundRepo.findAll();
    }

    @RequestMapping("kunder/add1")
    public String addKunder1(@RequestParam String namn, @RequestParam String ssn,
                             @RequestParam int cred){
        Kpi kpi = new Kpi(cred);
        repo.save(kpi);
        kundRepo.save(new Kund(namn, ssn, kpi));
        return "kund "+namn+" added (1) ";
    }

    @RequestMapping("kunder/add0")
    public String addKunder(@RequestParam String namn, @RequestParam String ssn,
                            @RequestParam Long id){
        Kpi kpi = repo.findById(id).get();
        if (kpi != null){
            kundRepo.save(new Kund(namn, ssn, kpi));
            return "kund "+namn+" added";
        }
        return "Ogiltigt id";
    }

    @RequestMapping("kunder/add2")
    public String addKunder2(@RequestParam String namn, @RequestParam String ssn,
                             @RequestParam int cred){
        Kpi kpi = new Kpi(cred);
        kundRepo.save(new Kund(namn, ssn, kpi));
        return "kund "+namn+" added (2) ";
    }

    @RequestMapping("kunder/delete/{id}")
    public String deleteKund(@PathVariable Long id){
        kundRepo.deleteById(id);
        return "kund "+id+" togs bort";
    }
/*
    //Nedanstående hör till N-1-filmen

    @RequestMapping("kunder/add3")
    public String addKunder3(@RequestParam String namn, @RequestParam String ssn,
                             @RequestParam int cred,  @RequestParam Long kategoriid){
        Kategori kat = katRepo.findById(kategoriid).get();
        if (kat != null){
            kundRepo.save(new Kund(namn, ssn, new Kpi(cred), kat));
            return "kund "+namn+" added";
        }
        return "Kund kunde inte läggas till";
    }

    //Nedanstående hör till N-M-filmen
    @RequestMapping("kunder/addKonto")
    public String addKonto(@RequestParam Long kundId, @RequestParam int saldo,
                           @RequestParam int ranta){
        Kund kund = kundRepo.findById(kundId).get();
        if (kund != null){
            kund.addKonto(new Konto(saldo, ranta));
            kundRepo.save(kund);
        }
        return "konto lades till hos kund med id "+kundId;
    }

    @RequestMapping("kunder/addKonto2")
    public String addKonto(@RequestParam Long kundId, @RequestParam Long kontoId){
        Kund kund = kundRepo.findById(kundId).get();
        Konto konto = kontoRepo.findById(kontoId).get();
        if (kund != null && konto != null){
            kund.addKonto(konto);
            kundRepo.save(kund);
        }
        return "konto lades till hos kund med id "+kundId;
    }

*/
}
