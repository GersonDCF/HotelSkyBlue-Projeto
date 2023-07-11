package subscription.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subscription.models.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {
}