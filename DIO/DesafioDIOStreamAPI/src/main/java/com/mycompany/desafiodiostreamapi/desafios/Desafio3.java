/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

/**
Desafio 3 - Verifique se todos os números da lista são positivos:
Com a ajuda da Stream API, verifique se todos os números da lista 
são positivos e exiba o resultado no console.
 */
public class Desafio3 {
    public Desafio3() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        Predicate<Integer> predicate = (n) -> n >= 0;
        boolean todosPositivos = numeros.stream().allMatch(predicate);
        System.out.println(todosPositivos ? "Todos positivos!" : "Há não-positivos.");
    }
    
    public static void main (String[] args) {
        new Desafio3();
    } 
}
