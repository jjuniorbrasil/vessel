package br.com.alura.literalura.model;

import jakarta.persistence.*;

@Entity(name = "livros")

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Livro() {

    }

    public Livro(Long id, String titulo, Autor autor, String idioma, Integer downloads) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.downloads = downloads;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    @Column()
    String titulo;

    @ManyToOne()
    Autor autor;

    @Column()
    String idioma;

    @Column()
    Integer downloads;

    public Livro(DadosLivro dados) {
        this.titulo = dados.titulo();
        this.autor = new Autor(dados.autores().get(0));
        this.idioma = dados.idiomas()[0];
        this.downloads = dados.downloads();
    }

    @Override
    public String toString() {
        return "Livro{" +
                "Título: '" + titulo + '\'' +
                ", Autor: " + autor.getNome() +
                ", Idioma: '" + idioma + '\'' +
                ", Número de downloads: " + downloads +
                '}';
    }
}
