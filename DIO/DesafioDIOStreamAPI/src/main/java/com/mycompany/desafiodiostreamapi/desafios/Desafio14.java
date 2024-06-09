/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
Desafio 14 - Encontre o maior número primo da lista:
Com a Stream API, encontre o maior número primo da lista e exiba o resultado no console.
 */
public class Desafio14 {
    
    public boolean numeroPrimo(int n) {
        // Número primo = divisível por 1 ou por ele mesmo, apenas.
        
        if (n == 2) return true;
        if (n <= 1 || n % 2 == 0) return false;
        for (int i = 3; i <= n / 2; i = i+2) {
            if (n % i == 0) 
            {
                return false;
            };
        }
        return true;
    }

    public Desafio14() {
    
    }
    
    public Desafio14(boolean execute) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3, 11);
        Predicate<Integer> p = x -> numeroPrimo(x);
        int maiorPrimo = numeros.stream().filter(p).sorted().collect(Collectors.toList()).getLast();
        System.out.println("Maior primo: " + maiorPrimo);
    }

    public static void main(String[] args) {
        new Desafio14(true);
    }
}
