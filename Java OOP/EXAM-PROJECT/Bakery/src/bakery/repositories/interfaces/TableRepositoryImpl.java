package bakery.repositories.interfaces;

import bakery.entities.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class TableRepositoryImpl<T extends Table> implements TableRepository<T> {
    private Collection<T> models;

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public T getByNumber(int number) {
        List<T> result = new ArrayList<>();

        result = this.models.stream().filter(f -> f.getTableNumber() == number).collect(Collectors.toList());

        return result.get(0) ;
    }


    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(T model) {
        this.models.add(model);
    }
}
