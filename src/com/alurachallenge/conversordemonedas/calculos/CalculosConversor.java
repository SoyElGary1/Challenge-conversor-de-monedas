package com.alurachallenge.conversordemonedas.calculos;

import com.alurachallenge.conversordemonedas.connection.Connection;
import com.alurachallenge.conversordemonedas.models.ExchangeRateApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class CalculosConversor {
    Connection connection = new Connection();

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();

    Validator validator = new Validator();

    public void operaciones(String menu) throws IOException, InterruptedException {
        int opcion;

        do {
            out.println(menu);
            opcion = validator.validadorOpcion();

            switch (opcion) {
                case 1 -> realizarConversion("USD", "ARS");
                case 2 -> realizarConversion("ARS", "USD");
                case 3 -> realizarConversion("USD", "BRL");
                case 4 -> realizarConversion("BRL", "USD");
                case 5 -> realizarConversion("USD", "COP");
                case 6 -> realizarConversion("COP", "USD");
                case 7 -> out.println("Gracias por usar nuestros servicios.");
                default -> out.println("Opción no disponible.\n");
            }
        } while (opcion != 7);

    }

    private void realizarConversion(String currCode, String currCode2) throws IOException, InterruptedException {
        double amount = validator.solicitarMonto();
        String url = generarUrl(currCode, currCode2, amount);
        String json = connection.connection(url);
        mostrarResultadoConversion(json, currCode2, amount);
    }

    private String generarUrl(String currCode, String currCode2, double amount) {
        return "https://v6.exchangerate-api.com/v6/95abcff540013968ba23e25e/pair/" + currCode + "/" + currCode2 + "/" + amount;
    }

    private void mostrarResultadoConversion(String json, String currCode2, double amount) {
        ExchangeRateApi exchangeRateApi = gson.fromJson(json, ExchangeRateApi.class);
        out.println("El valor " + amount + " corresponde al valor final de =>>> " + exchangeRateApi.conversion_result() + " " + currCode2);
        out.println();
    }
}
