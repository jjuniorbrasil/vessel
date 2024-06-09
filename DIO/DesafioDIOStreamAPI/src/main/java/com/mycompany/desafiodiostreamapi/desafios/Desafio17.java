/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import com.mycompany.desafiodiostreamapi.desafios.Desafio14;
import java.util.function.Predicate;

/**
Desafio 17 - Filtrar os números primos da lista:
Com a ajuda da Stream API, filtre os números primos da lista e exiba o resultado no console.
 */
public class Desafio17 {
    Desafio14 INSTANCE = new Desafio14();
    public Desafio17() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4);
        Predicate<Integer> predicate = x -> INSTANCE.numeroPrimo(x);
        List<Integer> primos = numeros.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(primos);
    }

    public static void main(String[] args) {
        new Desafio17();
    }
}
