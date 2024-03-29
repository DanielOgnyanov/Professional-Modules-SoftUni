package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entities.Users;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
    
    @Query("SELECT DISTINCT u FROM Users u JOIN FETCH u.posts p ORDER BY size(p) DESC, u.id")
    List<Users> result();
}
