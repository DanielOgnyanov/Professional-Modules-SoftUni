package bakery.repositories.interfaces;

import bakery.entities.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DrinkRepositoryImpl<T extends Drink> implements DrinkRepository<T> {

    private Collection<T> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }


    @Override
    public T getByNameAndBrand(String drinkName, String drinkBrand) {
        List<T> result = new ArrayList<>();

        result = this.models.stream().filter(f -> f.getName().equals(drinkName) && f.getBrand().equals(drinkBrand))
                .collect(Collectors.toList());
        return result.get(0);
    }

    @Override
    public Collection<T> getAll() {
        return  Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(T model) {
        models.add(model);

    }
}
