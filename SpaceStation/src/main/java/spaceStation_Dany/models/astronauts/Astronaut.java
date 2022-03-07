package spaceStation_Dany.models.astronauts;

import spaceStation_Dany.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
