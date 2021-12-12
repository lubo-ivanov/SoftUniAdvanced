package catHouse2.entities.cat;

import catHouse.entities.cat.BaseCat;

public class ShorthairCat extends BaseCat {
    private static final int Killograms = 7;
    private static final int increaseSize = 1;
    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(Killograms);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms()+increaseSize);
    }
}
