package softuni.exam.instagraphlite.models.dtos.jsons;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class PictureImportDto {

    @Expose
    private String path;
    @Expose
    private BigDecimal size;

    public PictureImportDto() {
    }

    @NotNull
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @DecimalMin(value = "500.00")
    @DecimalMax(value = "60000.00")
    @NotNull

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }
}
