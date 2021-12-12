package catHouse2.entities.toys;

import catHouse.entities.toys.BaseToy;

public class Ball extends BaseToy {
    private static final int soft = 1;
    private static final double price = 10;
    public Ball() {
        super(soft, price);
    }
}
