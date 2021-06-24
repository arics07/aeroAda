package com.ada.aerolinea.aerolineaAdaV1.controller;

import com.ada.aerolinea.aerolineaAdaV1.model.*;
import com.ada.aerolinea.aerolineaAdaV1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/aero/ada/v1")
public class MainController {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private PilotRepository pilotRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private FlightRepository flightRepository;

    //======================= READ ===============================//

    //-------------- all ------------------//
    @GetMapping(path = "/base/all")
    public @ResponseBody
    Iterable<Base> getAllBases(){
        return baseRepository.findAll();
    }

    @GetMapping(path = "/pilot/all")
    public @ResponseBody
    Iterable<Pilot> getAllPilots(){
        return pilotRepository.findAll();
    }

    @GetMapping(path = "/airplane/all")
    public @ResponseBody
    Iterable<Airplane> getAllAirplanes(){
        return airplaneRepository.findAll();
    }

    @GetMapping(path = "/crew/all")
    public @ResponseBody
    Iterable<Crew> getAllCrews(){
        return crewRepository.findAll();
    }

    @GetMapping(path = "/flight/all")
    public @ResponseBody
    Iterable<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    //--------------- by Id ---------------//
    @GetMapping(path = "/base/{id_base}")
    public @ResponseBody
    Optional<Base> getBaseById(@PathVariable("id_base") int id_base){
        return baseRepository.findById(id_base);
    }

    @GetMapping(path = "/pilot/{id_pilot}")
    public @ResponseBody
    Optional<Pilot> getPilotById(@PathVariable("id_pilot") int id_pilot){
        return pilotRepository.findById(id_pilot);
    }

    @GetMapping(path = "/airplane/{id_airplane}")
    public @ResponseBody
    Optional<Airplane> getAirplaneById(@PathVariable("id_airplane") int id_airplane){
        return airplaneRepository.findById(id_airplane);
    }

    @GetMapping(path = "/crew/{id_crew}")
    public @ResponseBody
    Optional<Crew> getCrewById(@PathVariable("id_crew") int id_crew){
        return crewRepository.findById(id_crew);
    }

    @GetMapping(path = "/flight/{id_flight}")
    public @ResponseBody
    Optional<Flight> getFlightById(@PathVariable("id_flight") int id_flight){
        return flightRepository.findById(id_flight);
    }

    //======================= CREATE ===============================//

    @PostMapping(path = "/base/create", consumes = "application/json", produces = "application/json")
    public Base createBase(@RequestBody Base base) {
        return baseRepository.save(base);
    }

    @PostMapping(path = "/pilot/create", consumes = "application/json", produces = "application/json")
    public Pilot createPilot(@RequestBody Pilot pilot) {
        return pilotRepository.save(pilot);
    }

    @PostMapping(path = "/airplane/create", consumes = "application/json", produces = "application/json")
    public Airplane createAirplane(@RequestBody Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @PostMapping(path = "/crew/create", consumes = "application/json", produces = "application/json")
    public Crew createCrew(@RequestBody Crew crew) {
        return crewRepository.save(crew);
    }

    @PostMapping(path = "/flight/create", consumes = "application/json", produces = "application/json")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    //================ UPDATE ==============================//

    @PutMapping(path= "/base/update")
    public Base updateBase (@RequestBody Base updatedBase) {
        return baseRepository.save(updatedBase);
    }

    @PutMapping(path= "/pilot/update")
    public Pilot updatePilot (@RequestBody Pilot updatedPilot) {
        return pilotRepository.save(updatedPilot);
    }

    @PutMapping(path= "/airplane/update")
    public Airplane updateAirplane (@RequestBody Airplane updatedAirplane) {
        return airplaneRepository.save(updatedAirplane);
    }

    @PutMapping(path= "/crew/update")
    public Crew updateCrew (@RequestBody Crew updatedCrew) {
        return crewRepository.save(updatedCrew);
    }

    @PutMapping(path= "/flight/update")
    public Flight updateFlight (@RequestBody Flight updatedFlight) {
        return flightRepository.save(updatedFlight);
    }

    //================ actualizar sólo la Base de un Pilot ====================//

    @PutMapping(path= "/pilot/{id_pilot}/update/base/{id_base}")
    public Pilot updateBaseInPilot (@PathVariable("id_pilot") int id_pilot, @PathVariable("id_base") int id_base) {
        Pilot pilot = pilotRepository.findById(id_pilot).get();
        Base base = baseRepository.findById(id_base).get();

        pilot.setBase(base);
        pilotRepository.save(pilot);

        return(pilot);
    }

    //================ DELETE ===========================//
    @DeleteMapping(path = "/base/delete/{id_base}")
    public @ResponseBody
    Iterable<Base> deleteBaseById (@PathVariable("id_base") int id_base) {
        baseRepository.deleteById(id_base);
        return baseRepository.findAll();  //devuelve la lista de Bases con el registro borrado
    }
}
