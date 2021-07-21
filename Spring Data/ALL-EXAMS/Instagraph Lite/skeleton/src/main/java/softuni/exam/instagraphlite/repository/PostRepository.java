package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entities.Posts;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Posts , Integer> {


    void findByUsers_Id(Integer id);
}
