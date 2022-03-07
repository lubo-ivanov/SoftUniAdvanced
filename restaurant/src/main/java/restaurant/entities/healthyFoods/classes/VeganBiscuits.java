package restaurant.entities.healthyFoods.classes;

public class VeganBiscuits extends Food{
        private static final double INITIAL_VEGAN_BISCUITS_PORTION = 205d;

    public VeganBiscuits(String name, double price) {
        super(name, INITIAL_VEGAN_BISCUITS_PORTION, price);
    }
}
