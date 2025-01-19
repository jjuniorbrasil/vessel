package forum.hub.api.model.DTO;

import java.time.LocalDateTime;

public record DadosTopico (String titulo, String mensagem, LocalDateTime dataCriacao, String nomeAutor, String curso){
}
