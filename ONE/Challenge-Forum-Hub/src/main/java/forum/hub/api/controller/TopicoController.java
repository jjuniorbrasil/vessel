package forum.hub.api.controller;

// Trecho de código suprimido

import forum.hub.api.repository.TopicoRepository;
import forum.hub.api.model.DTO.AtualizacaoTopicoDTO;
import forum.hub.api.model.DTO.DadosTopico;
import forum.hub.api.model.DTO.DadosTopicoLista;
import forum.hub.api.model.entities.Topico;
import jakarta.validation.Valid;
import forum.hub.api.model.DTO.TopicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public ResponseEntity listar() {
        var dados = topicoRepository.findAll().stream().map(DadosTopicoLista::new);
        return ResponseEntity.ok(dados);
    }

    @PostMapping
    @Transactional
    public ResponseEntity postar(@RequestBody @Valid DadosTopico dados) {
        topicoRepository.save(new Topico(dados));
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new TopicoDTO(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoTopicoDTO dados) {
        System.out.println("BATEU NO PUT");
        var topico = topicoRepository.getReferenceById(dados.id());
        System.out.println(topico);
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new TopicoDTO(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }
}
