package subscription.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import subscription.models.Hotel;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {


}