package softuni.exam.models.dtos.xmls;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketImportDto {

    @XmlElement(name = "serial-number")
    private String serialNumber;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "take-off")
    private String takeoff;


    @XmlElement(name = "from-town")
    private FromTownImportNameInTicket fromTown;

    @XmlElement(name = "to-town")
    private ToTownImportNameInTicket toTown;

    @XmlElement(name = "passenger")
    private PassengerImportInTicket passengerEmail;

    @XmlElement(name = "plane")
    private PlaneImportInTicket planeRegisterNumber;


    public TicketImportDto() {
    }



    @Length(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Min(value = 0)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public FromTownImportNameInTicket getFromTown() {
        return fromTown;
    }

    public void setFromTown(FromTownImportNameInTicket fromTown) {
        this.fromTown = fromTown;
    }

    public ToTownImportNameInTicket getToTown() {
        return toTown;
    }

    public void setToTown(ToTownImportNameInTicket toTown) {
        this.toTown = toTown;
    }

    public PassengerImportInTicket getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(PassengerImportInTicket passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public PlaneImportInTicket getPlaneRegisterNumber() {
        return planeRegisterNumber;
    }

    public void setPlaneRegisterNumber(PlaneImportInTicket planeRegisterNumber) {
        this.planeRegisterNumber = planeRegisterNumber;
    }

}
