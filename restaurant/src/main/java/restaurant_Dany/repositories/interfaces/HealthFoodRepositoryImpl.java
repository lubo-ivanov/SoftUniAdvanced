package restaurant_Dany.repositories.interfaces;

import restaurant_Dany.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private Collection<HealthyFood> healthyFoods;

    public HealthFoodRepositoryImpl() {
        this.healthyFoods = new ArrayList<>();
    }


    @Override
    public HealthyFood foodByName(String name) {
        return this.healthyFoods.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return this.healthyFoods;
    }

    @Override
    public void add(HealthyFood entity) {
        this.healthyFoods.add(entity);
    }
}
