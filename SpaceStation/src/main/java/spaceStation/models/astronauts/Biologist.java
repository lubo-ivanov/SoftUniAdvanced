package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private final static double OXYGEN = 70;

    public Biologist(String name) {
        super(name, OXYGEN);
    }

    @Override
    public void breath() {
        super.setOxygen(getOxygen() - 5);
        if (super.getOxygen() < 0) {
            super.setOxygen(0);
        }
    }
}
