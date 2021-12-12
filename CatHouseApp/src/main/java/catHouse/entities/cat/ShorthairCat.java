package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private static final int INITIAL_WEIGHT = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(INITIAL_WEIGHT);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 1);
    }
}
