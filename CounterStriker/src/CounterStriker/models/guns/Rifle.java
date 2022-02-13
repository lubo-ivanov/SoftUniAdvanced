package CounterStriker.models.guns;

public class Rifle extends GunImpl {

    private String name;
    private int bulletsCount;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < 10) {
            return 0;
        } else {
            shootBullets();
            return 10;
        }
    }

    @Override
    protected void shootBullets() {
        super.setBulletsCount(super.getBulletsCount() - 10);
    }

}
