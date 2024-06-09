/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem):
Com a Stream API, verifique se todos os números da lista são distintos (não se repetem) e exiba o resultado no console.
 */

public class Desafio9 {
    public Desafio9() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> checked = numeros.stream().distinct().collect(Collectors.toList());
        System.out.println(numeros.equals(checked) ? "Elementos não se repetem" : "Elementos se repetem");
    }
    
    public static void main (String[] args) {
        new Desafio9();
    } 
}
