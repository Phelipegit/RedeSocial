package ProjectPhelipe.RedeSocial.service;

import ProjectPhelipe.RedeSocial.model.CriarUsuarioRequest;
import ProjectPhelipe.RedeSocial.repository.RepositoryUser;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CriarUsuario {

    private RepositoryUser repositoryUser;

    public CriarUsuario(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    @Transactional
    public void criarUsuario(CriarUsuarioRequest usuarioRequest) {

    }
}
