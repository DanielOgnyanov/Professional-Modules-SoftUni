package softuni.exam.models.dtos.xmls;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneImportRootDto {


    @XmlElement(name = "plane")
    private List<PlaneImportDto> planeImportDto;

    public PlaneImportRootDto() {
    }

    public List<PlaneImportDto> getPlaneImportDto() {
        return planeImportDto;
    }

    public void setPlaneImportDto(List<PlaneImportDto> planeImportDto) {
        this.planeImportDto = planeImportDto;
    }
}
