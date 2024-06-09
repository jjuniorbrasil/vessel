/*
 * 
 * 
 */
package com.mycompany.desafiodiostreamapi.desafios;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Desafio 18 - Verifique se todos os números da lista são iguais: Utilizando a
 * Stream API, verifique se todos os números da lista são iguais e exiba o
 * resultado no console.
 */
public class Desafio18 {

    public Desafio18() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4);
        boolean todosIguais = numeros.stream().allMatch(x -> x.equals(numeros.get(numeros.size() / 2)));
        saoTodosIguais(todosIguais);
        
        // alternativamente...
        
        todosIguais = numeros.stream().distinct().collect(Collectors.toList()).size() == 1;
        saoTodosIguais(todosIguais);
    }
    
    private void saoTodosIguais(boolean todosIguais) {
        System.out.println(todosIguais ? "Todos os números são iguais" : "Existem números diferentes entre si");
    }
    
    public static void main(String[] args) {
        new Desafio18();
    }

}
