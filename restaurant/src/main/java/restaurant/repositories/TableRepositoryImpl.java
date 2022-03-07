package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

public class TableRepositoryImpl<T> extends BaseRepository<T> implements TableRepository<T> {
    @Override
    public T byNumber(int number) {
        for (T entity : super.getAllEntities()) {
            if (((Table) entity).getTableNumber() == number) {
                return entity;
            }
        }
        return null;
    }
}
