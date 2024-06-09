/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;

import java.util.List;
import java.util.Arrays;

/**
 * Desafio 19 - Encontre a soma dos números divisíveis por 3 e 5: Com a Stream
 * API, encontre a soma dos números da lista que são divisíveis tanto por 3
 * quanto por 5 e exiba o resultado no console.
 */
public class Desafio19 {

    public Desafio19() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4);
        int sum = numeros.stream().filter(x -> x % 3 == 0 && x % 5 == 0).reduce(0, Integer::sum);
        System.out.println("Soma dos números divisíveis por 3 e 5: " + sum);
    }

    public static void main(String[] args) {
        new Desafio19();
    }

}
