package forum.hub.api.model.DTO;

import jakarta.validation.constraints.NotNull;
import forum.hub.api.model.enums.Status;

public record AtualizacaoTopicoDTO(@NotNull Long id, String titulo, String mensagem, Status status) {
}
