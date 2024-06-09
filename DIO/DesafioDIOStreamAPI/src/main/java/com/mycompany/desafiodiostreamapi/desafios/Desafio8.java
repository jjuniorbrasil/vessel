/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;
import java.util.List;
import java.util.Arrays;

/**
Desafio 8 - Somar os dígitos de todos os números da lista:
Utilizando a Stream API, realize a soma dos dígitos de todos os números da lista e 
* exiba o resultado no console.
 */

public class Desafio8 {
    public Desafio8() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        System.out.println("Soma dos números no array: " + numeros.stream().reduce(0, Integer::sum));
    }
    
    public static void main (String[] args) {
        new Desafio8();
    } 
}
