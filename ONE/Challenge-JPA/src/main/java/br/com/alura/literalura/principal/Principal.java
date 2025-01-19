package br.com.alura.literalura.principal;

import br.com.alura.literalura.model.*;

import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.service.ConsumoApi;
import br.com.alura.literalura.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private List<DadosLivro> dadosLivro = new ArrayList<>();

    private AutorRepository autorRepository;

    private LivroRepository repositorio;

    public Principal(LivroRepository repository, AutorRepository autorRepository) {
        this.repositorio = repository;
        this.autorRepository = autorRepository;
    }

    public void exibeMenu() {
        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                    *** Escolha o número de sua opção ***                    
                                        
                    1- Buscar Livro pelo título
                    2- Listar livros registrados
                    3- Listar autores registrados
                    4- Listar autores vivos em um determinado ano
                    5- Listar livros em um determinado idioma
                                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroWeb();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEm();
                    break;
                case 5:
                    listarLivrosEmDeterminadoIdioma();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void listarLivrosEmDeterminadoIdioma() {
        System.out.println("Digite o idioma:");
        String idioma = leitura.nextLine();

        List<Livro> livros = repositorio.findLivrosPorIdioma(idioma);

        System.out.println("Livros no idioma: " + idioma);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado nesse idioma.");
        } else {
            livros.forEach(livro -> System.out.println(livro.toString()));
        }
    }

    private void listarAutoresVivosEm() {
        try {
            System.out.println("Digite o ano:");
            String entrada = leitura.nextLine();
            int ano = Integer.parseInt(entrada);

            List<Autor> autores = autorRepository.findAutoresVivosNoAno(ano);

            System.out.println("Autores vivos em: " + ano);
            if (autores.isEmpty()) {
                System.out.println("Nenhum autor encontrado.");
            } else {
                autores.forEach(autor -> System.out.println(autor));
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Certifique-se de digitar um número válido.");
        }
    }

    private void listarLivrosRegistrados() {
        List<Livro> livros = repositorio.findAll();
        System.out.println("Livros registrados: ");
        livros.forEach(livro -> {
            System.out.println(livro.toString());
        });
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();
        System.out.println("Autores registrados: ");
        autores.forEach(livro -> {
            System.out.println(livro.toString());
        });
    }

    private void buscarLivroWeb() {
        DadosLivro dados = getDadosLivro();
        Livro livro = new Livro(dados);
        autorRepository.save(livro.getAutor());
        repositorio.save(livro);
        System.out.println(livro);
    }

    private DadosLivro getDadosLivro() {
        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = leitura.nextLine();
        var jsonBusca = consumo.obterDados(ENDERECO + nomeLivro.replace(" ", "%20"));
        DadosBusca dadosBusca = conversor.obterDados(jsonBusca, DadosBusca.class);
        return dadosBusca.livros().get(0);
    }
}