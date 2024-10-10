package com.alurachallenge.conversordemonedas.main;

import com.alurachallenge.conversordemonedas.calculos.CalculosConversor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        CalculosConversor calculosConversor = new CalculosConversor();
        calculosConversor.operaciones(menu());
    }

    public static String menu(){

        return """
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                """;
    }
}
