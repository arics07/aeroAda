package com.ada.aerolinea.aerolineaAdaV1.service.impl;

import com.ada.aerolinea.aerolineaAdaV1.service.ICalculator;

public class CalculatorImpl implements ICalculator {


    @Override
    public int suma(int a, int b) {
        return a+b;
    }

    @Override
    public int resta(int a, int b) {
        return a-b;
    }

    @Override
    public int multiplicacion(int a, int b) {
        return a*b;
    }

    @Override
    public int division(int a, int b) {
        try {
            return a/b;
        } catch (ArithmeticException e) {
            return (0);
        }
    }
}
