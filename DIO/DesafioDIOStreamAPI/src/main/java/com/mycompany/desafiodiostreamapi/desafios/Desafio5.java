/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;
import java.util.List;
import java.util.Arrays;

/**
Desafio 5 - Calcule a média dos números maiores que 5:
Com a Stream API, calcule a média dos números maiores que 5 e exiba o resultado no console.
 */
public class Desafio5 {
    public Desafio5() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        double med = numeros.stream().filter(n -> n > 5).mapToDouble(Integer::doubleValue).average().orElse(0);
        System.out.println("Média dos números maiores do que 5: " + med);
    }
    
    public static void main (String[] args) {
        new Desafio5();
    } 
}
