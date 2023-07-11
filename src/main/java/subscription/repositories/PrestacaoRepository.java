package subscription.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subscription.models.Prestacao;

@Repository
public interface PrestacaoRepository extends JpaRepository<Prestacao, Long> {
}