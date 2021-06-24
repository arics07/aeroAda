package com.ada.aerolinea.aerolineaAdaV1.controller;

import com.ada.aerolinea.aerolineaAdaV1.service.ICalculator;
import com.ada.aerolinea.aerolineaAdaV1.service.impl.CalculatorImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "aero/ada/v1/calculator")
public class CalculatorController {

    private ICalculator calculator = new CalculatorImpl();

    @GetMapping(path = "/sumar/{a}/{b}")
    public @ResponseBody
    Integer sumar(@PathVariable("a") int a, @PathVariable("b") int b) {
        return calculator.suma(a,b);
    }

    @GetMapping(path = "/dividir/{a}/{b}")
    public @ResponseBody
    Integer dividir(@PathVariable("a") int a, @PathVariable("b") int b) {
        return calculator.division(a,b);
    }
}
