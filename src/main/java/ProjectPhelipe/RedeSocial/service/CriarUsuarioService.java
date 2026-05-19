package ProjectPhelipe.RedeSocial.service;

import ProjectPhelipe.RedeSocial.config.ArgonConfig;
import ProjectPhelipe.RedeSocial.entity.EntityUser;
import ProjectPhelipe.RedeSocial.model.CriarUsuarioRequest;
import ProjectPhelipe.RedeSocial.model.CriarUsuarioResponse;
import ProjectPhelipe.RedeSocial.repository.RepositoryUser;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarUsuarioService {

    private RepositoryUser repositoryUser;
    private final ArgonConfig argonConfig;

    public CriarUsuarioService(RepositoryUser repositoryUser, ArgonConfig argonConfig) {
        this.repositoryUser = repositoryUser;
        this.argonConfig = argonConfig;
    }

    @Transactional
    public ResponseEntity<CriarUsuarioResponse> criarUsuario(CriarUsuarioRequest usuarioRequest) {
        Optional<EntityUser> existEmail = repositoryUser.findByEmail(usuarioRequest.getEmail());
        Optional<EntityUser> existUsername = repositoryUser.findByUsername(usuarioRequest.getUsername().trim().toLowerCase());

        if(existEmail.isPresent()) {
            return ResponseEntity.badRequest().body(new CriarUsuarioResponse(false));
        }

        if(existUsername.isPresent()) {
            return ResponseEntity.badRequest().body(new CriarUsuarioResponse(false));
        }

        return ResponseEntity.ok(new CriarUsuarioResponse(true));
    }
}
