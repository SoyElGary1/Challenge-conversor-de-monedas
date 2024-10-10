package com.alurachallenge.conversordemonedas.calculos;

import com.alurachallenge.conversordemonedas.connection.Connection;
import com.alurachallenge.conversordemonedas.models.ExchangeRate;
import com.alurachallenge.conversordemonedas.models.ExchangeRateApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class CalculosConversor {
    Connection connection = new Connection();

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();

    public void operaciones() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String currCode = "";
        String currCode2 = "";
        double amount = 0;
        String url;
        int opcion;
        String json;

        do {

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    currCode = "USD";
                    currCode2 = "EUR";
                    System.out.println("Ingrese la cantidad:");
                    amount = sc.nextDouble();
                    url = "https://v6.exchangerate-api.com/v6/95abcff540013968ba23e25e/pair/" + currCode + "/" + currCode2 + "/" + amount;
                    json = connection.connection(url);
                    ExchangeRateApi exchangeRateApi = gson.fromJson(json, ExchangeRateApi.class);
                    System.out.println();
                }
                case 2: {

                }
                case 2: {

                }
                case 3: {

                }
                case 4: {

                }
                case 5: {

                }
                case 6: {

                }
                case 7: {

                }
            }
        } while (opcion != 7);
    }
}
