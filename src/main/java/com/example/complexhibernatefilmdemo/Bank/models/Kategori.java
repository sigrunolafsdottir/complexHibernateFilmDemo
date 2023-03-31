package com.example.complexhibernatefilmdemo.Bank.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    //Här till 1-N-filmen
    @OneToMany(mappedBy="kategori")
    private List<Kund> kunder;

    public Kategori(String name){
        this.name=name;
    }

}
