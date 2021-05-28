package com.aerolineaAda.aeroAda.controller;

import com.aerolineaAda.aeroAda.model.Airplane;
import com.aerolineaAda.aeroAda.model.Base;
import com.aerolineaAda.aeroAda.model.Pilot;
import com.aerolineaAda.aeroAda.repository.AirplaneRepository;
import com.aerolineaAda.aeroAda.repository.BaseRepository;
import com.aerolineaAda.aeroAda.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path= "/airline/ada/v1")
public class MainController {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private PilotRepository pilotRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @GetMapping(path= "/base/all")
    public @ResponseBody
    Iterable<Base> getAllBases(){
        return baseRepository.findAll();
    }

    @GetMapping(path = "/base/{id_base}")
    public @ResponseBody
    Optional<Base> getBaseById(@PathVariable("id_base") int id_base) {
        return baseRepository.findById(id_base);
    }

    @GetMapping(path = "pilot/all")
    public @ResponseBody
    Iterable<Pilot> getAllPilots() {
        return pilotRepository.findAll();
    }

    @GetMapping(path = "/pilot/{id}")
    public @ResponseBody
    Optional<Pilot> getPilotById(@PathVariable("id") int id) {
        return pilotRepository.findById(id);
    }

    @GetMapping(path = "airplane/all")
    public @ResponseBody
    Iterable<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }
}
