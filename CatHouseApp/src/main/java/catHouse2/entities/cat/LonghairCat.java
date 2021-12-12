package catHouse2.entities.cat;

import catHouse.entities.cat.BaseCat;

public class LonghairCat extends BaseCat {
    private static final int Killograms = 9;
    private static final int increaseSize = 3;
    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(Killograms);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms()+increaseSize);
    }
}
