/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;
import java.util.List;
import java.util.Arrays;

/**
Desafio 4 - Remova todos os valores ímpares:
Utilize a Stream API para remover os valores ímpares da 
lista e imprima a lista resultante no console.
 */
public class Desafio4 {
    public Desafio4() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        numeros.stream().filter((n) -> n % 2 == 0).forEach(System.out::println);
    }
    
    public static void main (String[] args) {
        new Desafio4();
    } 
}
