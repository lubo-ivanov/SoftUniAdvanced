package spaceStation_Dany.models.astronauts;

public class Biologist extends BaseAstronaut{
    private final static double INITIAL_OXYGEN = 70;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        this.setOxygen(getOxygen() - 5);
    }
}
