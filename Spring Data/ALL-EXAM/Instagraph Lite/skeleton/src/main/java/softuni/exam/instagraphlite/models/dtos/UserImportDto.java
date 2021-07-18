package softuni.exam.instagraphlite.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;
import softuni.exam.instagraphlite.models.entities.Pictures;

import javax.validation.constraints.NotNull;

public class UserImportDto {

    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private String profilePicture;

    public UserImportDto() {
    }


    @NotNull
    @Length(min = 2,max = 18)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Length(min = 4)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @NotNull
    public String getProfilePictures() {
        return profilePicture;
    }

    public void setProfilePictures(String profilePictures) {
        this.profilePicture = profilePictures;
    }
}
