package ProjectPhelipe.RedeSocial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class EntityPostagem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String postagem_url;

    private String mensagem_post;

    @CreationTimestamp
    private LocalDateTime createAt;

    @ManyToOne()
    @JoinColumn(name = "profile_id")
    private EntityProfileUser profile_id;

    @OneToMany(mappedBy = "entityPostagem")
    private List<EntityCurtida> entityCurtidaList = new ArrayList<>();

    public EntityPostagem(String postagem_url,String mensagem_post) {
        this.postagem_url = postagem_url;
        this.mensagem_post = mensagem_post;
    }

    public EntityPostagem() {

    }
}
