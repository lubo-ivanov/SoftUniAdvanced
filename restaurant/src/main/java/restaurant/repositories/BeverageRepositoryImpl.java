package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

public class BeverageRepositoryImpl<T> extends BaseRepository<T> implements BeverageRepository<T> {
    @Override
    public T beverageByName(String drinkName, String drinkBrand) {
        for (T entity : super.getAllEntities()) {
            if (((Beverages) entity).getName().equals(drinkName) && ((Beverages) entity).getBrand().equals(drinkBrand)) {
                return entity;
            }
        }
        return null;
    }
}
