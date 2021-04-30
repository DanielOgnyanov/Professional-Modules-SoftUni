package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository<T extends Player> implements Repository<T> {

    private Collection<T> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }







    @Override
    public Collection<T> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(T model) {
        if(model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        this.models.add(model);

    }

    @Override
    public boolean remove(T model) {
        if (this.models.contains(model)) {
            this.models.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public T findByName(String name) {
        List<T> firstGunWithThisName =
                this.models
                        .stream()
                        .filter(f -> f.getUsername().equals(name))
                        .collect(Collectors.toList());

        if(!firstGunWithThisName.isEmpty())  {

            return firstGunWithThisName.get(0);
        }
        return null;
    }
}
