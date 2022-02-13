package CounterStriker.models.guns;

public class Pistol extends GunImpl {

    private String name;
    private int bulletsCount;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }


    @Override
    public int fire() {
        if (super.getBulletsCount() < 1) {
            return 0;
        } else {
            shootBullets();
            return 1;
        }
    }

    @Override
    protected void shootBullets() {
        setBulletsCount(super.getBulletsCount() - 1);
    }
}
