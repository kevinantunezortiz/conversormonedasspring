package com.aluracursos.conversormonedas.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ApiMonedas {
    private HashMap monedas = new HashMap<String, String>();



    public Resultado obtenerResultado(String moneda1, String moneda2, String cantidad) {
        String codigoMoneda1 = monedas.get(moneda1).toString();
        String codigoMoneda2 = monedas.get(moneda2).toString();
        String apikey = "f04170f78a1f513606b22a0b";
        String direccion = "https://v6.exchangerate-api.com/v6/"+apikey+"/pair/"+codigoMoneda1+"/"+codigoMoneda2+"/"+cantidad;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();
        Gson gson = new Gson();
        Resultado resultado = gson.fromJson(json,Resultado.class);
        resultado.setCodigoMoneda1(codigoMoneda1);
        resultado.setCodigoMoneda2(codigoMoneda2);
        return resultado;
    }
    public HashMap<String,String> obtenerMonedas(){
        monedas.put("Peso Mexicano", "MXN");
        monedas.put("Dólar Estadounidense", "USD");
        monedas.put("Euro", "EUR");
        monedas.put("Peso Argentino", "ARS");
        monedas.put("Real Brasileño", "BRL");
        monedas.put("Peso Colombiano", "COP");
        return monedas;
    }
}
