package softuni.exam.instagraphlite.models.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users extends BaseEntity{

    private String username;
    private String password;
    private Pictures profilePictures;
    private Set<Posts> posts;


    public Users() {
    }


    @Column(name = "username", nullable = false,unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    @JoinColumn(name = "profile_picture_id",referencedColumnName = "id")
    public Pictures getProfilePicture() {
        return profilePictures;
    }

    public void setProfilePicture(Pictures profilePictures) {
        this.profilePictures = profilePictures;
    }

    @OneToMany(mappedBy = "users")
    public Set<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Set<Posts> posts) {
        this.posts = posts;
    }
}
