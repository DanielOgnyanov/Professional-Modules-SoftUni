package softuni.exam.instagraphlite.models.entities;


import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Posts extends BaseEntity{

    private String caption;

    private Users users;

    private Pictures pictures;

    public Posts() {
    }

    @Column(name = "caption")
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne
    @JoinColumn(name = "picture_id",referencedColumnName = "id")
    public Pictures getPictures() {
        return pictures;
    }

    public void setPictures(Pictures pictures) {
        this.pictures = pictures;
    }
}


