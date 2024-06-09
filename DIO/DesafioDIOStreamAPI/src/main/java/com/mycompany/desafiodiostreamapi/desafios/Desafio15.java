/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;

import java.util.List;
import java.util.Arrays;

/**
Desafio 15 - Verifique se a lista contém pelo menos um número negativo:
Utilizando a Stream API, verifique se a lista contém pelo menos um número 
* negativo e exiba o resultado no console.
 */
public class Desafio15 {
    public Desafio15() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4);
        boolean anyNegative = numeros.stream().anyMatch(x -> x < 0);
        System.out.println(anyNegative ? "Há numeros negativos." : "Não há numeros negativos.");
    }

    public static void main(String[] args) {
        new Desafio15();
    }
}
