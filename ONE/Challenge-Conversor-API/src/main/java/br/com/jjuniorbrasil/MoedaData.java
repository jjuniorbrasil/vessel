package br.com.jjuniorbrasil;

import java.util.Map;

public record MoedaData(String base_code, Map<String, Double> conversion_rates) {
}
