package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DriverRepository<T extends Driver> implements Repository<T>{

    private Collection<T> models;

    public DriverRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public T getByName(String name) {
        List<T> result = new ArrayList<>();

        result = this.models.stream().filter(f -> f.getName().equals(name))
                .collect(Collectors.toList());//////////

        return result.get(0);
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(T model) {
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
}
