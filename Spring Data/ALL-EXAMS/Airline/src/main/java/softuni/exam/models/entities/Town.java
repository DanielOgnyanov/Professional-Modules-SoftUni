package softuni.exam.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    private String name;
    private int population;
    private String guide;
    private Set<Passenger> passenger;
    private Set<Ticket> fromTown;
    private Set<Ticket> toTown;


    public Town() {
    }


    @Column(name = "name",unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "population")
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Column(name = "guide")
    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }


    @OneToMany(mappedBy = "town")
    public Set<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(Set<Passenger> passenger) {
        this.passenger = passenger;
    }

    @OneToMany(mappedBy = "fromTown")
    public Set<Ticket> getFromTown() {
        return fromTown;
    }

    public void setFromTown(Set<Ticket> fromTown) {
        this.fromTown = fromTown;
    }

    @OneToMany(mappedBy = "toTown")
    public Set<Ticket> getToTown() {
        return toTown;
    }

    public void setToTown(Set<Ticket> toTown) {
        this.toTown = toTown;
    }
}
