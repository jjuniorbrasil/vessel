package forum.hub.api.controller;

import forum.hub.api.infra.security.TokenService;
import forum.hub.api.model.DTO.DadosTokenJWT;
import forum.hub.api.model.entities.Usuario;
import jakarta.validation.Valid;
import forum.hub.api.model.entities.DadosAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService service;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var auth = manager.authenticate(token);
        var authToken = service.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(authToken));
    }
}

