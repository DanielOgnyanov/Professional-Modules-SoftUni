package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.PictureImportDto;
import softuni.exam.instagraphlite.models.entities.Pictures;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {
    private static final String PICTURES_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;


    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository,
                              ModelMapper modelMapper,
                              Gson gson,
                              ValidatorUtil validatorUtil) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validatorUtil = validatorUtil;

    }


    @Override
    public Boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(PICTURES_PATH)));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        PictureImportDto[] pictureImportDtos =
                this.gson.fromJson(this.readFromFileContent(), PictureImportDto[].class);


        for (PictureImportDto pictureImportDto : pictureImportDtos) {

            Optional<Pictures> byPath = this.pictureRepository.findByPath(pictureImportDto.getPath());


            if (this.validatorUtil.isValid(pictureImportDto) && byPath.isEmpty()) {


                Pictures pictures = this.modelMapper.map(pictureImportDto, Pictures.class);

                this.pictureRepository
                        .saveAndFlush(pictures);

                sb.append(String.format("Successfully imported Picture, with size %.2f", pictureImportDto.getSize()))
                        .append(System.lineSeparator());


            } else {

                sb.append("Invalid pictures").append(System.lineSeparator());
            }
        }


        return sb.toString().trim();
    }

    @Override
    public String exportPictures() {
        return null;
    }
}
