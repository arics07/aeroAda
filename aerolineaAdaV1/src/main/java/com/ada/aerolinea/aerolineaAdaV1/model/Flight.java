package com.ada.aerolinea.aerolineaAdaV1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_flight;

    private String name;

    private String origin_name;

    private String destination_city;

    @OneToOne
    @JoinColumn(name = "pilot", referencedColumnName = "id_pilot")
    private Pilot pilot;

    @OneToOne
    @JoinColumn(name = "airplane", referencedColumnName = "id_airplane")
    private Airplane airplane;

    private Date date;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "Flight_Crew",
            joinColumns = @JoinColumn(name = "id_flight"),
            inverseJoinColumns = @JoinColumn(name = "id_crew")
    )
    private Set<Crew> flightCrew;

    public Flight(){

    }

    public Flight(int id_flight, String name, String origin_name, String destination_city, Pilot pilot, Airplane airplane, Date date, Set<Crew> flightCrew) {
        this.id_flight = id_flight;
        this.name = name;
        this.origin_name = origin_name;
        this.destination_city = destination_city;
        this.pilot = pilot;
        this.airplane = airplane;
        this.date = date;
        this.flightCrew = flightCrew;
    }

    public int getId_flight() {
        return id_flight;
    }

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public String getDestination_city() {
        return destination_city;
    }

    public void setDestination_city(String destination_city) {
        this.destination_city = destination_city;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Crew> getFlightCrew() {
        return flightCrew;
    }

    public void setFlightCrew(Set<Crew> flightCrew) {
        this.flightCrew = flightCrew;
    }
}
