package com.aluracursos.conversormonedas.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class ApiMonedas {
    private HashMap monedas = new HashMap<String, String>();

    public ApiMonedas() {
        crearMonedas();
    }
    public HashMap<String, String> getMonedas() {
        return monedas;
    }
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
        resultado.setMoneda1(moneda1);
        resultado.setMoneda2(moneda2);
        resultado.setCantidad(cantidad);
        resultado.setFechaHoraActual(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
        return resultado;
    }
    public void crearMonedas(){
        monedas.put("Peso Mexicano", "MXN");
        monedas.put("Dólar Estadounidense", "USD");
        monedas.put("Euro", "EUR");
        monedas.put("Peso Argentino", "ARS");
        monedas.put("Real Brasileño", "BRL");
        monedas.put("Peso Colombiano", "COP");
        monedas.put("Yen Japonés", "JPY");
    }
}
