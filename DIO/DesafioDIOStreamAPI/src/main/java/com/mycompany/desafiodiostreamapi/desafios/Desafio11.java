/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;
import java.util.List;
import java.util.Arrays;
import java.util.function.Function;

/**
Desafio 11 - Encontre a soma dos quadrados de todos os números da lista:
Utilizando a Stream API, encontre a soma dos quadrados de todos os números
* da lista e exiba o resultado no console.
 */

public class Desafio11 {
    public Desafio11() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        Function<Integer, Integer> sumSquares = (x) -> x*x;
        System.out.println(numeros.stream().map(sumSquares).reduce(0, Integer::sum));
    }
    
    public static void main (String[] args) {
        new Desafio11();
    } 
}
