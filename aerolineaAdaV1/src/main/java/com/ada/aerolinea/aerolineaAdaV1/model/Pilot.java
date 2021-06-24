package com.ada.aerolinea.aerolineaAdaV1.model;

import javax.persistence.*;

@Entity
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pilot;

    private String name;

    @OneToOne()  //cascade = CascadeType.DETACH, fetch = FetchType.LAZY
    @JoinColumn(name = "base_code", referencedColumnName = "id_base")
    private Base base;

    private int hours;

    public Pilot(){

    }

    public Pilot(int id_pilot, String name, Base base, int hours) {
        this.id_pilot = id_pilot;
        this.name = name;
        this.base = base;
        this.hours = hours;
    }

    public int getId_pilot() {
        return id_pilot;
    }

    public void setId_pilot(int id_pilot) {
        this.id_pilot = id_pilot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

}
