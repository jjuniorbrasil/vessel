package com.mycompany.desafiodiostreamapi.desafios;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

/*
Desafio 2 - Imprima a soma dos números pares da lista:
Utilizando a Stream API, realize a soma dos números pares da
lista e exiba o resultado no console.
*/

public class Desafio2 {
   public Desafio2() {
       List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
       Predicate<Integer> p = (n) -> n % 2 == 0;
       
       int sum = numeros.stream().filter(p).reduce(0, Integer::sum);
       System.out.println(sum);
   }
   
   public static void main(String[] args) {
       new Desafio2();
   }
}
