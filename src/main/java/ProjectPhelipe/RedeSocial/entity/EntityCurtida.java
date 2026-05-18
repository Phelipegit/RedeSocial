package ProjectPhelipe.RedeSocial.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class EntityCurtida {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_profileUser")
    private EntityProfileUser entityProfileUser;
    @ManyToOne
    @JoinColumn(name = "id_postagem")
    private EntityPostagem entityPostagem;

    @CreationTimestamp
    private LocalDateTime createAt;

    public EntityCurtida(EntityProfileUser entityProfileUser, EntityPostagem entityPostagem) {
        this.entityProfileUser = entityProfileUser;
        this.entityPostagem = entityPostagem;
    }

    public EntityCurtida() {

    }
}
