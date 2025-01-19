package forum.hub.api.model.entities;

import forum.hub.api.model.DTO.AtualizacaoTopicoDTO;
import forum.hub.api.model.DTO.DadosTopico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import forum.hub.api.model.enums.Status;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Tópico")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull

    private String titulo;
    @NotNull
    private String mensagem;
    @NotNull
    @Column(name = "data_de_criacao")
    private LocalDateTime dataCriacao;
    @NotNull
    @Column(name = "autor")
    private String nomeAutor;

    private String curso;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NAO_RESPONDIDO;

    public Long getId() {
        return id;
    }

    public @NotNull String getTitulo() {
        return titulo;
    }

    public @NotNull String getMensagem() {
        return mensagem;
    }

    public @NotNull LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public @NotNull String getNomeAutor() {
        return nomeAutor;
    }

    public String getCurso() {
        return curso;
    }

    public @NotNull Status getStatus() {
        return status;
    }

    public Topico() {
    }

    public Topico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, String nomeAutor, String curso, Status status) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.nomeAutor = nomeAutor;
        this.curso = curso;
        this.status = status;
    }

    public Topico(DadosTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.dataCriacao();
        this.curso = dados.curso();
        this.nomeAutor = dados.nomeAutor();
    }

    public void atualizarInformacoes(AtualizacaoTopicoDTO dados) {
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
    }
}