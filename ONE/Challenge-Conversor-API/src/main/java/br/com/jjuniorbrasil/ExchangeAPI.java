package br.com.jjuniorbrasil;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeAPI {
    private String url = "https://v6.exchangerate-api.com/v6/";
    private String apiKey = "d48d424d200af2a1e2042c95";
    private String codOrig;
    private String codDest;
    private double valor;
    private MoedaData moedaData;
    private Gson gson;
    private Double taxa;

    public String getCodOrig() {
        return codOrig.toUpperCase();
    }

    public String getCodDest() {
        return codDest.toUpperCase();
    }

    public double getValor() {
        return valor;
    }

    public ExchangeAPI(String codOrig, String codDest) {
        this.codOrig = codOrig.toLowerCase();
        this.codDest = codDest.toLowerCase();
    }

    public void fetchData() {
        String uri = url + apiKey + "/latest/" + codOrig.toLowerCase();
        gson = new Gson();
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();
            HttpResponse<String> response;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            moedaData = gson.fromJson(response.body(), MoedaData.class);
            taxa = moedaData.conversion_rates().get(codDest.toUpperCase());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }

    public void setValor(double v) {
        this.valor = v;
    }

    public double getValorConvertido() {
        return this.valor * this.taxa;
    };
}
