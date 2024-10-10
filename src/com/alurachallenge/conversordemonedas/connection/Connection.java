package com.alurachallenge.conversordemonedas.connection;

import com.alurachallenge.conversordemonedas.models.ExchangeRate;
import com.alurachallenge.conversordemonedas.models.ExchangeRateApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;

public class Connection {

    private String url;


    public String connection(String url) throws IOException, InterruptedException {
        this.url = url;
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            return "Error " + e;
        }
    }


}
