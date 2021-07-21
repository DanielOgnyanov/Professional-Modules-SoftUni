package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.xmls.PostsImportDto;
import softuni.exam.instagraphlite.models.dtos.xmls.PostsImportRootDto;
import softuni.exam.instagraphlite.models.entities.Pictures;
import softuni.exam.instagraphlite.models.entities.Posts;
import softuni.exam.instagraphlite.models.entities.Users;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidatorUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {


    private static final String POSTS_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository,
                           ModelMapper modelMapper, XmlParser xmlParser,
                           ValidatorUtil validatorUtil, PictureRepository pictureRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Boolean аreImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(POSTS_PATH)));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();


        PostsImportRootDto postsImportRootDto =
                this.xmlParser.parseXml(PostsImportRootDto.class, POSTS_PATH);



        for (PostsImportDto actual : postsImportRootDto.getPostsImportDtos()) {

            Optional<Pictures> byPath =
                    this.pictureRepository.findByPath(actual.getPath().getPath());

            Optional<Users> byName =
                    this.userRepository.findByUsername(actual.getUsername().getUsername());

            if(this.validatorUtil.isValid(actual) && byPath.isPresent() && byName.isPresent()) {

                Posts posts = this.modelMapper.map(actual, Posts.class);
                posts.setPictures(byPath.get());
                posts.setUsers(byName.get());

                this.postRepository.saveAndFlush(posts);

                sb.append(String.format("Successfully imported Post, made by %s"
                        ,actual.getUsername().getUsername()))
                        .append(System.lineSeparator());

            } else {
                sb.append("Invalid Post")
                        .append(System.lineSeparator());
            }



        }


        return sb.toString();
    }
}
