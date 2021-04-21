package bakery.repositories.interfaces;

import bakery.entities.BakedFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FoodRepositoryImpl<T extends BakedFood> implements FoodRepository<T> {
    private Collection<T> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }


    @Override
    public T getByName(String name) {
        List<T> result = new ArrayList<>();

        result = this.models.stream().filter(f -> f.getName().equals(name)).collect(Collectors.toList());
        return result.get(0);
    }

    @Override
    public Collection<T> getAll() {
        return  Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(T model) {
        this.models.add(model);
    }
}
