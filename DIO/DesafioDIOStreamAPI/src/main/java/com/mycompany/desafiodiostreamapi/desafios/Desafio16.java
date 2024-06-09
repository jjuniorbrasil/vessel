/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Desafio 16 - Agrupe os números em pares e ímpares: Utilize a Stream API para
 * agrupar os números em duas listas separadas, uma contendo os números pares e
 * outra contendo os números ímpares da lista original, e exiba os resultados no
 * console.
 */
public class Desafio16 {

    public Desafio16() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4);
        List<Integer> pares = numeros.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        List<Integer> impares = numeros.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        System.out.println(pares + "\n" + impares);
    }

    public static void main(String[] args) {
        new Desafio16();
    }
}
