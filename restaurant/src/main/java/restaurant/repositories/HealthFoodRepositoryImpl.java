package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

public class HealthFoodRepositoryImpl<T> extends BaseRepository<T> implements HealthFoodRepository<T> {

    @Override
    public T foodByName(String name) {
        for (T entity : super.getAllEntities()) {
            if (((HealthyFood) entity).getName().equals(name)) {
                return entity;
            }
        }
        return null;
    }
}
