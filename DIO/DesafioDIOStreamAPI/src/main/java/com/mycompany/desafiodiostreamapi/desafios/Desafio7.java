/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
Desafio 7 - Encontrar o segundo número maior da lista:
Com a ajuda da Stream API, encontre o segundo número maior da lista e exiba o resultado no console.
 */

public class Desafio7 {
    public Desafio7() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> ordNumeros = numeros.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Segundo maior: " + ordNumeros.get(1));
    }
    
    public static void main (String[] args) {
        new Desafio7();
    } 
}
