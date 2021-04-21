package bakery.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Repository<T> implements bakery.repositories.interfaces.Repository<T> {
    private Collection<T> models;

    public Repository() {
        this.models = new ArrayList<>();
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
