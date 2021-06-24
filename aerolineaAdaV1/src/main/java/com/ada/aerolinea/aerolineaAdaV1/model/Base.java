package com.ada.aerolinea.aerolineaAdaV1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_base;

    private String city;

    public Base(){
    }

//    public Base(int id_base, String city) {
//       this.id_base = id_base;
//        this.city = city;
//    }

    public int getId_base() {
        return id_base;
    }

    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
