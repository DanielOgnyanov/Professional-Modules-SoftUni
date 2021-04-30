package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {


    private Repository<Gun> gunRepository;
    private Repository<Player> playerRepository;
    private Field field;


    public ControllerImpl() {
        this.gunRepository = new GunRepository<>();
        this.playerRepository = new PlayerRepository<>();
        this.field = new FieldImpl();
    }







    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun currGun;

        switch (type) {

            case "Pistol":
                currGun = new Pistol(name,bulletsCount);
                gunRepository.add(currGun);
                break;

            case "Rifle":
                currGun = new Rifle(name,bulletsCount);
                gunRepository.add(currGun);
                break;

            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_GUN,name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Player currPlayer;

        if (gunRepository.findByName(gunName) == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        switch (type) {

            case "Terrorist":
                currPlayer = new Terrorist(username,health,armor,gunRepository.findByName(gunName));
                playerRepository.add(currPlayer);
                break;

            case "CounterTerrorist":
                currPlayer = new CounterTerrorist(username,health,armor,gunRepository.findByName(gunName));
                playerRepository.add(currPlayer);
                break;

            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER,username);
    }

    @Override
    public String startGame() {
        field.start(playerRepository.getModels());
        return field.start(playerRepository.getModels());
    }

    @Override
    public String report() {

        return print().toString().trim();
    }

    private StringBuilder print() {
        StringBuilder output = new StringBuilder();

        this.playerRepository
                .getModels()
                .stream()
                .sorted((f,s) -> {

                    int result = f.getClass().getSimpleName().compareTo(s.getClass().getSimpleName());

                    if (result == 0) {
                        result = Integer.compare(s.getHealth(), f.getHealth());
                    }

                    if(result == 0)  {
                        result = f.getUsername().compareTo(s.getUsername());
                    }
                    return result;
                })
                .forEach(print -> output.append(print.toString())
                .append(System.lineSeparator()));
        return output;
    }
}
