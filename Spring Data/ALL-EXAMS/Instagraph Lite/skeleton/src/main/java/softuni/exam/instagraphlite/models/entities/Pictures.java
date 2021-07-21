package softuni.exam.instagraphlite.models.entities;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "pictures")
public class Pictures extends BaseEntity{

    private String path;
    private double size;
    private Set<Users> user;
    private Set<Posts> posts;

    public Pictures() {
    }

    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "size")
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @OneToMany(mappedBy = "profilePicture")
    public Set<Users> getUser() {
        return user;
    }

    public void setUser(Set<Users> user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "pictures")
    public Set<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Set<Posts> posts) {
        this.posts = posts;
    }
}
