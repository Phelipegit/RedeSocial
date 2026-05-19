package ProjectPhelipe.RedeSocial.model;

import lombok.Getter;

@Getter
public class LoginUsuarioRequest {

    private String email;

    private String password;

    public LoginUsuarioRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
