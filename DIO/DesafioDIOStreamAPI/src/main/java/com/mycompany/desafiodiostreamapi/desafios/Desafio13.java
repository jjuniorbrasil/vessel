/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Desafio 13 - Filtrar os números que estão dentro de um intervalo: Utilize a
 * Stream API para filtrar os números que estão dentro de um intervalo
 * específico (por exemplo, entre 5 e 10) e exiba o resultado no console.
 */
public class Desafio13 {

    public Desafio13() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        int limInf = 2, limSup = 4;
        List<Integer> filtrado = numeros.stream().filter(x -> x >= limInf && x <= limSup).collect(Collectors.toList());
        for (int i : filtrado) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        new Desafio13();
    }
}
