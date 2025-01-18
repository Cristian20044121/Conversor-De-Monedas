package com.conversor.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

/**
 * Servicio para obtener tasas de cambio utilizando ExchangeRate-API.
 */
public class ExchangeRateService {
    private static final String API_KEY = "5b6c2245d6ff82e91ac2fc10";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";
    private final HttpClient client;
    private final Gson gson;

    /**
     * Constructor que inicializa el cliente HTTP y el parser JSON.
     */
    public ExchangeRateService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    /**
     * Obtiene la tasa de cambio entre dos monedas.
     *
     * @param fromCurrency 
     * @param toCurrency   
     * @return 
     */
    public double getExchangeRate(String fromCurrency, String toCurrency) {
        if (fromCurrency == null || toCurrency == null || fromCurrency.isEmpty() || toCurrency.isEmpty()) {
            System.err.println("Monedas inválidas proporcionadas.");
            return 0;
        }

        try {
            URI uri = new URI(API_URL + fromCurrency + "/" + toCurrency);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.err.println("Error en la API: " + response.statusCode());
                return 0;
            }

            RateResponse rateResponse = gson.fromJson(response.body(), RateResponse.class);
            return rateResponse.getConversionRate();

        } catch (Exception e) {
            System.err.println("Error al obtener la tasa de cambio: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }
}

/**
 * representa la respuesta JSON de la API de ExchangeRate.
 */
class RateResponse {
    private double conversion_rate;

    public double getConversionRate() {
        return conversion_rate;
    }

    public void setConversionRate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }
}
