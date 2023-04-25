package com.example.complexhibernatefilmdemo.Bank.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kategori {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;

    public Kategori(String name){
        this.name=name;
    }

    //Hör till 1-N-filmen
    @OneToMany(mappedBy="kategori")
    private List<Kund> kunder;



}
