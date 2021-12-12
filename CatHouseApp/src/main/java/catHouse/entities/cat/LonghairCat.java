package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private static final int INITIAL_WEIGHT = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(INITIAL_WEIGHT);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 3);
    }
}
