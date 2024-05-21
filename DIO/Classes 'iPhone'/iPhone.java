/*
 * 
 * 
 */
package com.mycompany.iphone;

/**
 *
 * @author junio
 */
public class iPhone implements AparelhoTelefonico, Navegador, ReprodutorMusical {
    
    // Aparelho
    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz...");
    };
    
    @Override
    public void atender() {
        System.out.println("Atendendo ligação...");
    };
    
    @Override
    public void ligar() {
        System.out.println("Discando...");
    };

    @Override
    public void exibirPagina() {
        System.out.println("Exibindo página...");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba...");
    }

    @Override
    public void adicionarPagina() {
        System.out.println("Adicionando nova página...");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando...");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando...");
    }

    @Override
    public void selecionarMusica() {
        System.out.println("Selecionando música...");
    }
}
