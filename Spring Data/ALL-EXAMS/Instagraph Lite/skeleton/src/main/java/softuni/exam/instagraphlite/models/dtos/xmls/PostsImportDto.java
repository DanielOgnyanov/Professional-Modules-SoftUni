package softuni.exam.instagraphlite.models.dtos.xmls;


import org.hibernate.validator.constraints.Length;
import softuni.exam.instagraphlite.models.entities.Pictures;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostsImportDto {

    @XmlElement(name = "caption")
    private String caption;

    @XmlElement(name = "user")
    private UserImportNameDto user;

    @XmlElement(name = "picture")
    private PictureImportPathDto path;


    public PostsImportDto() {
    }


    @NotNull
    @Length(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @NotNull
    public UserImportNameDto getUsername() {
        return user;
    }

    public void setUsername(UserImportNameDto username) {
        this.user = username;
    }


    @NotNull
    public PictureImportPathDto getPath() {
        return path;
    }

    public void setPath(PictureImportPathDto path) {
        this.path = path;
    }
}
