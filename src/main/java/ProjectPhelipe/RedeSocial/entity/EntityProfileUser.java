package ProjectPhelipe.RedeSocial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class EntityProfileUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String url_foto = "https://res.cloudinary.com/dcvnvdjlb/image/upload/v1779067143/573323465_1219825463302212_7278921664109726296_n_irmghp.jpg";

    private Boolean isPrivate = false;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private EntityUser user_id;

    @OneToMany(mappedBy = "profile_id",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntityPostagem> listaPostagens = new ArrayList<>();

    @OneToMany(mappedBy = "entityProfileUser", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EntityCurtida> listaCurtidas = new ArrayList<>();

    public EntityProfileUser(EntityUser user_id) {
        this.user_id = user_id;
    }

    public EntityProfileUser() {
    }
}
