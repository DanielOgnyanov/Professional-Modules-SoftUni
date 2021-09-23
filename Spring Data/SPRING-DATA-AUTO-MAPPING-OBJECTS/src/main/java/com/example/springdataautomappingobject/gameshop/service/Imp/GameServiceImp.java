package com.example.springdataautomappingobject.gameshop.service.Imp;

import com.example.springdataautomappingobject.gameshop.domain.dtos.AddGameDto;
import com.example.springdataautomappingobject.gameshop.domain.dtos.DeleteGameDto;
import com.example.springdataautomappingobject.gameshop.domain.dtos.UserDto;
import com.example.springdataautomappingobject.gameshop.domain.entities.Game;
import com.example.springdataautomappingobject.gameshop.domain.entities.Role;
import com.example.springdataautomappingobject.gameshop.repositories.GameRepository;
import com.example.springdataautomappingobject.gameshop.service.GameService;
import com.example.springdataautomappingobject.gameshop.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GameServiceImp implements GameService {

    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final GameRepository gameRepository;
    private UserDto userDto;

    @Autowired
    public GameServiceImp(ValidatorUtil validatorUtil, ModelMapper modelMapper, GameRepository gameRepository) {
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.gameRepository = gameRepository;
    }

    @Override
    public String addGame(AddGameDto addGameDto) {

        StringBuilder sb = new StringBuilder();

        if (this.userDto == null || this.userDto.getRole().equals(Role.USER)) {

            sb.append("Invalid logged in user");
        }
        else if (this.validatorUtil.isValid(addGameDto)){
            Game game = this.modelMapper.map(addGameDto,Game.class);
            this.gameRepository.saveAndFlush(game);

            sb.append(String.format("Added %s",game.getTitle()));


        } else {

            this.validatorUtil.violations(addGameDto)
                    .forEach(e -> sb.append(e.getMessage()).append(System.lineSeparator()));

        }
        return sb.toString().trim();
    }

    @Override
    public void setLoggedUser(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String deleteGame(DeleteGameDto deleteGameDto) {

        StringBuilder sb = new StringBuilder();

        if (this.userDto == null || this.userDto.getRole().equals(Role.USER)) {

            sb.append("Invalid logged in user");
        }

        Optional<Game> game = this.gameRepository.findById(deleteGameDto.getId());


        if (game.isPresent()) {
            sb.append(String.format("Game %s was deleted.",game.get().getTitle()));
            this.gameRepository.delete(game.get());
        } else {
            sb.append("Cannot find game");
        }


        return sb.toString().trim();
    }
}
