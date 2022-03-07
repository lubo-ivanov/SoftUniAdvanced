package restaurant.entities.healthyFoods.classes;

public class Salad extends Food {
    private static final double INITIAL_SALAD_PORTION = 150d;

    public Salad(String name, double price) {
        super(name, INITIAL_SALAD_PORTION, price);
    }

}
