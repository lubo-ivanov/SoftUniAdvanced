package restaurant_Dany.repositories.interfaces;

import restaurant_Dany.entities.drinks.interfaces.Beverages;

import java.util.ArrayList;
import java.util.Collection;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new ArrayList<>();
    }


    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.beverages.stream().filter(b -> b.getName().equals(drinkName) && b.getBrand().equals(drinkBrand)).findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return this.beverages;
    }

    @Override
    public void add(Beverages entity) {
        this.beverages.add(entity);
    }
}
