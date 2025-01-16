package br.com.jjuniorbrasil;

import java.util.Scanner;

public class UI {
    public static void clear() {
        for (int i = 0; i < 9; i++) {
            System.out.println();
        }
    }

    public static void menuPrincipal() {
        clear();
        System.out.println("""
                ============================================
                            CONVERSOR DE MOEDAS
                     **     ===================      **
                                Selecione:
                            (1) -   Converter
                            (2) -   Sair
                            ===================
                ============================================
                """);
    }

    public static void selecaoDeMoedas(boolean origem) {
        clear();
        System.out.printf("""
                ============================================
                            CONVERSOR DE MOEDAS
                     **     ===================      **
                        Selecione a moeda de %s:
                        códigos códigos códigos...        
                """, origem ? "ORIGEM" : "para CONVERSÃO");
    }

    public static double inserirValor(Scanner entry) {
        clear();
        System.out.printf("""
                ============================================
                            CONVERSOR DE MOEDAS
                     **     ===================      **
                        Insira o valor para conversão:
                Valor: \s""");
        double valor = entry.nextDouble();
        System.out.println("============================================");

        return valor;
    }

    public static void resultado(ExchangeAPI api) {
        clear();
        System.out.printf("""
                ============================================
                            CONVERSOR DE MOEDAS
                     **     ===================      **
                \t%f %s para %s:
                \t%f %s
                ============================================
               Qualquer número para continuar. / (2) para sair.
                """, api.getValor(), api.getCodOrig(), api.getCodDest(), api.getValorConvertido(), api.getCodDest());
    }
}
