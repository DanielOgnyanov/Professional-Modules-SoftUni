package softuni.exam.models.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity{


    private String serialNumber;
    private BigDecimal price;
    private LocalDateTime takeoff;
    private Passenger passenger;
    private Plane plane;
    private Town fromTown;
    private Town toTown;


    public Ticket() {
    }

    @Column(name = "serial_number",unique = true)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "take_off")
    public LocalDateTime getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(LocalDateTime takeoff) {
        this.takeoff = takeoff;
    }


    @ManyToOne
    @JoinColumn(name = "passenger_id",referencedColumnName = "id")
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


    @ManyToOne
    @JoinColumn(name = "plane_id",referencedColumnName = "id")
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @ManyToOne
    @JoinColumn(name = "from_town_id",referencedColumnName = "id")
    public Town getFromTown() {
        return fromTown;
    }

    public void setFromTown(Town town) {
        this.fromTown = town;
    }


    @ManyToOne
    @JoinColumn(name = "to_town_id",referencedColumnName = "id")
    public Town getToTown() {
        return toTown;
    }

    public void setToTown(Town toTown) {
        this.toTown = toTown;
    }
}
