package softuni.exam.instagraphlite.models.dtos.xmls;


import softuni.exam.instagraphlite.models.dtos.xmls.PostsImportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostsImportRootDto {

    @XmlElement(name = "post")
    private List<PostsImportDto> postsImportDtos;


    public PostsImportRootDto() {
    }

    public List<PostsImportDto> getPostsImportDtos() {
        return postsImportDtos;
    }

    public void setPostsImportDtos(List<PostsImportDto> postsImportDtos) {
        this.postsImportDtos = postsImportDtos;
    }
}
