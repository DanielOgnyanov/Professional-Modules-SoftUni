package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.jsons.UserImportDto;
import softuni.exam.instagraphlite.models.entities.Pictures;
import softuni.exam.instagraphlite.models.entities.Posts;
import softuni.exam.instagraphlite.models.entities.Users;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final static String USERS_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;
    private final PictureRepository pictureRepository;
    private final PostRepository postRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Gson gson, ValidatorUtil validatorUtil, PictureRepository pictureRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.pictureRepository = pictureRepository;
        this.postRepository = postRepository;
    }


    @Override
    public Boolean аreImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(USERS_PATH)));
    }

    @Override
    public String importUsers() throws IOException {

        StringBuilder sb = new StringBuilder();

        UserImportDto[] userImportDtos =
                this.gson.fromJson(this.readFromFileContent(), UserImportDto[].class);


        for (UserImportDto userImportDto : userImportDtos) {

            Optional<Users> byUsername =
                    this.userRepository.findByUsername(userImportDto.getUsername());

            String path = userImportDto.getProfilePictures();


            Optional<Pictures> byPath =
                     this.pictureRepository.findByPath(path);





            if (this.validatorUtil.isValid(userImportDto) && byUsername.isEmpty()  && !byPath.isEmpty()) {

                Users users = this.modelMapper.map(userImportDto, Users.class);

                users.setProfilePicture(byPath.get());
                this.userRepository.saveAndFlush(users);

                sb
                        .append(String.format("Successfully imported User: %s",userImportDto.getUsername()))
                        .append(System.lineSeparator());

            } else  {
                sb.append("Invalid User").append(System.lineSeparator());
            }


        }


        return sb.toString();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();

        List<Users> toPrint = this.userRepository.result();


        for (Users users : toPrint) {

            sb.append(String.format("User: %s", users.getUsername()))
                    .append(System.lineSeparator())
                    .append(String.format("Post count: %d", users.getPosts().size()))
                    .append(System.lineSeparator());

            users.getPosts().forEach(p -> {

                String post = p.getCaption();
                double size = p.getPictures().getSize();

                sb
                        .append(String.format("==Post Details:"))
                        .append(System.lineSeparator())
                        .append(String.format("----Caption: %s", p.getCaption()))
                        .append(System.lineSeparator())
                        .append(String.format("----Picture Size: %.2f", p.getPictures().getSize()))
                        .append(System.lineSeparator());


            });


        }
        return sb.toString();
    }
}
