package forum.hub.api.model.DTO;

import forum.hub.api.model.entities.Topico;
import forum.hub.api.model.enums.Status;

public record DadosTopicoLista(Long id, String titulo, String mensagem, Status status) {
    public DadosTopicoLista(Topico topico) {
        this(

        topico.getId(),
        topico.getTitulo(),
        topico.getMensagem(),
                topico.getStatus()
        );
    }
}
