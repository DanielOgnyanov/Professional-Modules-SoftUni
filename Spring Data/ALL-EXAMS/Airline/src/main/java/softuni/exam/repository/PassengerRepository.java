package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Optional<Passenger> findByEmail(String email);
    
    @Query("SELECT DISTINCT p FROM Passenger AS p JOIN FETCH p.ticketSet s ORDER BY size(s) DESC, p.email")
    List<Passenger> result();

}
