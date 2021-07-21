package softuni.exam.instagraphlite.models.entities;


import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private Integer id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false,unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
