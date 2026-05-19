package ProjectPhelipe.RedeSocial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class EntityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    private LocalDateTime createAt;

    @OneToOne(mappedBy = "user_id",cascade = CascadeType.ALL)
    private EntityProfileUser entityProfileUser;

    public EntityUser(String email,String nome,String password,String username) {
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.username = username;
    }

    public EntityUser() {

    }
}
