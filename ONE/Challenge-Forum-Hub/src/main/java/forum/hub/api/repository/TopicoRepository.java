package forum.hub.api.repository;

import forum.hub.api.model.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}