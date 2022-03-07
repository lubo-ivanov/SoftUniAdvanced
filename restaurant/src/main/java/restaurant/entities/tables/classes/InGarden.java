package restaurant.entities.tables.classes;

public class InGarden extends BaseTable {
    private static final double PRICE_PER_PERSON = 4.5;

    public InGarden(int number, int size) {
        super(number, size, PRICE_PER_PERSON);
    }
}
