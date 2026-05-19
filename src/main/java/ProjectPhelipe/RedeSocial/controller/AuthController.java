package ProjectPhelipe.RedeSocial.controller;

import ProjectPhelipe.RedeSocial.model.CriarUsuarioRequest;
import ProjectPhelipe.RedeSocial.model.CriarUsuarioResponse;
import ProjectPhelipe.RedeSocial.service.CriarUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CriarUsuarioService criarUsuarioService;

    public AuthController(CriarUsuarioService criarUsuarioService) {
        this.criarUsuarioService = criarUsuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<CriarUsuarioResponse> login(@RequestBody CriarUsuarioRequest usuarioRequest) {
        return criarUsuarioService.criarUsuario(usuarioRequest);
    }
}
