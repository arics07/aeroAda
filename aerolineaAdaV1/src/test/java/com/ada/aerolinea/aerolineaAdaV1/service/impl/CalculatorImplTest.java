package com.ada.aerolinea.aerolineaAdaV1.service.impl;

import com.ada.aerolinea.aerolineaAdaV1.service.ICalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorImplTest {

    ICalculator calculator = new CalculatorImpl();

    @Test
    void sumarTest(){

        int a = 3;
        int b = 5;

        int c = calculator.suma(a,b);

        assertTrue(c>0);
        assertEquals(c, 8);
        assertEquals(c, a+b);
    }

    @Test
    void sumarUnNumYCeroTest(){

        int a = 3;
        int b = 0;

        int c = calculator.suma(a,b);

        assertTrue(c>0);
        assertEquals(c, 3);
        assertEquals(c, a+b);
        assertEquals(c, a);
    }

    @Test
    void restaTest(){

        int a = 7;
        int b = 2;

        int c = calculator.resta(a,b);

        assertEquals(c, 5);
        assertEquals(c, a-b);

    }

    @Test
    void positivoMenosNegativo(){

        int a = 9;
        int b = -5;

        int c = calculator.resta(a,b);

        assertEquals(c, 14);
        assertEquals(c, a-b);

    }


    @Test
    void multiplicacionTest(){

        int a = 3;
        int b = 10;

        int c = calculator.multiplicacion(a,b);

        assertEquals(c, 30);
        assertEquals(c, a*b);
        assertTrue(c==30);
        assertTrue(c>0);

    }

    @Test
    void multiplicacionNegativoYPositivoTest(){

        int a =-2;
        int b = 6;

        int c = calculator.multiplicacion(a,b);

        assertTrue(c<0);
        assertEquals(c, -12);
        assertEquals(c, a*b);

    }

    //división:
    // común,
    //por 1,
    //por el mismo número,
    //negativo y positivo,
    //por cero

    @Test
    void divisionTest(){

        int a = 20;
        int b = 4;

        int c = calculator.division(a,b);

        assertTrue(c>0);
        assertEquals(c, 5);
        assertEquals(c, a/b);

    }

    @Test
    void divisionPorUnoTest(){

        int a = 17;
        int b = 1;

        int c = calculator.division(a,b);

        assertTrue(c>0);
        assertEquals(c, 17);
        assertEquals(c, a/b);

    }

    @Test
    void divisionPorCeroTest(){

        int a = 7;
        int b = 0;

        try {
            int c = calculator.division(a, b);
        } catch (ArithmeticException e){
            assertEquals(e.getMessage(), "/ by zero");
        }

    }

}
