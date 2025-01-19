package br.com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "autores")
public class Autor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
            Long id;

    private Integer anoNascimento;
    private Integer anoMorte;
    private String nome;

    public Autor() {


    }

    public Autor(Long id, Integer anoNascimento, Integer anoMorte, String nome, List<Livro> livros) {
        this.id = id;
        this.anoNascimento = anoNascimento;
        this.anoMorte = anoMorte;
        this.nome = nome;
        this.livros = livros;
    }

    @OneToMany()
    List<Livro> livros;

    public Autor(DadosAutor dadosAutor) {
        this.anoMorte = dadosAutor.anoMorte();
        this.nome = dadosAutor.nome();
        this.anoNascimento = dadosAutor.anoNascimento();
    }

    public Long getId() {
        return id;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public Integer getAnoMorte() {
        return anoMorte;
    }

    public String getNome() {
        return nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                ", Nome: '" + nome + '\'' +
                ", Ano do Nascimento: " + anoNascimento +
                ", Ano da Morte: " + anoMorte +
                '}';
    }
}
