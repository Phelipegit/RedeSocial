package ProjectPhelipe.RedeSocial.repository;

import ProjectPhelipe.RedeSocial.entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryUser extends JpaRepository<EntityUser, UUID> {
}
