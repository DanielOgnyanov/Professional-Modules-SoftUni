package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.jsons.TownsImportDto;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class TownServiceImp implements TownService {

    private static final String TOWN_PATH = "src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public TownServiceImp(TownRepository townRepository,
                          ModelMapper modelMapper, Gson gson,
                          ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(TOWN_PATH)));
    }

    @Override
    public String importTowns() throws IOException {

        StringBuilder sb = new StringBuilder();


        TownsImportDto[] townsImportDtos =
                this.gson.fromJson(this.readTownsFileContent(), TownsImportDto[].class);



        for (TownsImportDto currValueOfTown : townsImportDtos) {


            if (this.validationUtil.isValid(currValueOfTown)) {

                Town town = this.modelMapper.map(currValueOfTown, Town.class);

                this.townRepository.saveAndFlush(town);

                sb.append(String.format("Successfully imported Town %s - %d",
                        currValueOfTown.getName(),currValueOfTown.getPopulation()))
                        .append(System.lineSeparator());

            } else {
                sb.append("Invalid Town").append(System.lineSeparator());
            }


        }

        return sb.toString().trim();
    }
}
