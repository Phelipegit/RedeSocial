package ProjectPhelipe.RedeSocial.repository;

import ProjectPhelipe.RedeSocial.entity.EntityProfileUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RepositoryProfileUser extends JpaRepository<EntityProfileUser, UUID> {
    Optional<EntityProfileUser> findByUsername(String name);
}
