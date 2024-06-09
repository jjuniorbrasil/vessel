/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

/**
Desafio 6 - Verificar se a lista contém algum número maior que 10:
Utilize a Stream API para verificar se a lista contém algum número maior que 10 e exiba o resultado no console.
 */

public class Desafio6 {
    public Desafio6() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        Predicate<Integer> predicate = n -> n > 10;
        System.out.println((numeros.stream().anyMatch(predicate)) ? "Existe elemento maior que 10" : "Não existe elemento maior que 10");
    }
    
    public static void main (String[] args) {
        new Desafio6();
    } 
}
