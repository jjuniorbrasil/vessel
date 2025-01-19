package forum.hub.api.model.DTO;

import forum.hub.api.model.entities.Topico;
import forum.hub.api.model.enums.Status;

import java.time.LocalDateTime;

public record TopicoDTO (Long id, String titulo, String mensagem, LocalDateTime dataCriacao, String nomeAutor, String curso, Status status){
    public TopicoDTO(Topico topico) {
        this(
        topico.getId(),
        topico.getTitulo(),
        topico.getMensagem(),
        topico.getDataCriacao(),
        topico.getNomeAutor(),
        topico.getCurso(), topico.getStatus()
        );

    }
}
