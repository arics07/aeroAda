package com.ada.aerolinea.aerolineaAdaV1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_crew;

    private String name;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "base_code", referencedColumnName = "id_base")
    private Base base;

    private String position;

    @JsonBackReference
    @ManyToMany(mappedBy = "flightCrew")
    private Set<Flight> flights;

    public Crew() {

    }

    public Crew(int id_crew, String name, Base base, String position, Set<Flight> flights) {
        this.id_crew = id_crew;
        this.name = name;
        this.base = base;
        this.position = position;
        this.flights = flights;
    }

    public int getId_crew() {
        return id_crew;
    }

    public void setId_crew(int id_crew) {
        this.id_crew = id_crew;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

}
