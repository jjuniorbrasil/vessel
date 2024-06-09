/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;
import java.util.List;
import java.util.Arrays;

/**
Desafio 12 - Encontre o produto de todos os números da lista:
Com a ajuda da Stream API, encontre o produto de todos os números da
lista e exiba o resultado no console.
 */

public class Desafio12 {
    public Desafio12() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        System.out.println(numeros.stream().reduce(0, Integer::sum));
    }
    
    public static void main (String[] args) {
        new Desafio12();
    } 
}
