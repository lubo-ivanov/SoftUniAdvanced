package catHouse2.entities.houses;

import catHouse.entities.houses.BaseHouse;

public class ShortHouse extends BaseHouse {
    private static final int Capasity = 15;
    public ShortHouse(String name) {
        super(name, Capasity);
    }
}
