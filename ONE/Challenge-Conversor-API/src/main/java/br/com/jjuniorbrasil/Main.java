package br.com.jjuniorbrasil;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UI.menuPrincipal();
        Scanner entry = new Scanner(System.in);
        int opt = entry.nextInt();
        while (opt != 2) {
            UI.selecaoDeMoedas(true);
            entry.nextLine();
            String codOrig = entry.nextLine();
            UI.selecaoDeMoedas(false);
            String codDest = entry.nextLine();
            ExchangeAPI api = new ExchangeAPI(codOrig, codDest);
            api.fetchData();
            api.setValor(UI.inserirValor(entry));
            UI.resultado(api);
            opt = entry.nextInt();
        }
        System.out.println("\nObrigado por utilizar este serviço! (^ w  ^)/");
    }
}