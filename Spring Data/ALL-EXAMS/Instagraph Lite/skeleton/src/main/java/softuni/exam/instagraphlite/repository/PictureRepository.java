package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entities.Pictures;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface PictureRepository extends JpaRepository<Pictures, Integer> {

    Optional<Pictures> findByPath(String path);

}
