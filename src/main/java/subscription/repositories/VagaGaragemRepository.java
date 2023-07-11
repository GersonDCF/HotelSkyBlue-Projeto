package subscription.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subscription.models.VagaGaragem;

@Repository
public interface VagaGaragemRepository extends JpaRepository<VagaGaragem, Long> {
}
