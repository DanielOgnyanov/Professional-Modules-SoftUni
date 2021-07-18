package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entities.Pictures;

import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Pictures, Integer> {

    Optional<Pictures> findByPath(String path);
}
