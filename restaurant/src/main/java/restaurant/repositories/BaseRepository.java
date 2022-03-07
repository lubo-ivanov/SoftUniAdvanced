package restaurant.repositories;

import restaurant.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseRepository<T> implements Repository<T> {
    private Collection<T> entities;

    public BaseRepository() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Collection<T> getAllEntities() {
        return this.entities;
    }

    @Override
    public void add(T entity) {
        entities.add(entity);
    }


}
