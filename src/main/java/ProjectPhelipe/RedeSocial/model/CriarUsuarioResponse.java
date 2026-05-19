package ProjectPhelipe.RedeSocial.model;

import lombok.Getter;

@Getter
public class CriarUsuarioResponse {

    private boolean createUser_response;

    public CriarUsuarioResponse(boolean createUser_response) {
        this.createUser_response = createUser_response;
    }
}
