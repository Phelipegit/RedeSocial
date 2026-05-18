package ProjectPhelipe.RedeSocial.model;

import lombok.Getter;

@Getter
public class CriarUsuarioRequest {

    private String nome;

    private String username;

    private String password;

    public CriarUsuarioRequest(String nome, String username, String password) {
        this.nome = nome;
        this.username = username;
        this.password = password;
    }
}
