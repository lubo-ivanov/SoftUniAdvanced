package halfLife;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class PlayerTests {
    private List<Gun> guns;
    private static final String USERNAME = "Pesho";
    private static final int HEALTH = 100;
    private Player player = new Player(USERNAME, HEALTH);
    ;

    @Before
    public void createGunsRepo() {
        guns = new ArrayList<>();
        Gun gun1 = new Gun("Gun1", 100);
        Gun gun2 = new Gun("Gun2", 101);
        Gun gun3 = new Gun("Gun3", 102);
        Gun gun4 = new Gun("Gun4", 103);
        guns.add(gun1);
        guns.add(gun2);
        guns.add(gun3);
        guns.add(gun4);
        player.addGun(gun1);
        player.addGun(gun2);
        player.addGun(gun3);
        player.addGun(gun4);
    }


    @Test
    public void returnsProperUserName() {
        Assert.assertEquals(USERNAME, this.player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfUsernameIsrEmpty() {
        Player player = new Player(" ", HEALTH);
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfUsernameIsNull() {
        Player player = new Player(null, HEALTH);
    }

    @Test
    public void setProperUsername() {
        Player player = new Player(USERNAME, HEALTH);
        Assert.assertEquals(USERNAME, player.getUsername());

    }

    @Test
    public void returnsProperHealth() {
        Assert.assertEquals(HEALTH, player.getHealth());
    }

    @Test
    public void setProperHealth() {
        Player player = new Player(USERNAME, HEALTH);
        Assert.assertEquals(HEALTH, player.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionIfHealthIsNegative() {
        Player player = new Player(USERNAME, -20);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void gunCollectionCannotBeModifiedThroughGetter() {
        player.getGuns().add(new Gun("Gun5", 105));
    }

    @Test
    public void returnProperGunCollection() {
        Gun[] expectedGuns = guns.toArray(Gun[]::new);
        Gun[] resultGuns = player.getGuns().toArray(Gun[]::new);
        Assert.assertArrayEquals(expectedGuns, resultGuns);
    }

    @Test
    public void removeProperGun() {
        Assert.assertEquals(4, player.getGuns().size());
        Gun gunToRemove = player.getGun("Gun1");
        player.removeGun(gunToRemove);
        Assert.assertEquals(3, player.getGuns().size());
    }

    @Test
    public void doesNotRemoveNonExistingGun() {
        Assert.assertEquals(4, player.getGuns().size());
        Gun gunToRemove = player.getGun("Gun");
        player.removeGun(gunToRemove);
        Assert.assertEquals(4, player.getGuns().size());
    }

    @Test
    public void addsProperGun() {
        guns = new ArrayList<>();
        Gun gun1 = new Gun("Gun1", 100);
        Gun gun2 = new Gun("Gun2", 101);
        Gun gun3 = new Gun("Gun3", 102);
        Gun gun4 = new Gun("Gun4", 103);
        guns.add(gun1);
        guns.add(gun2);
        guns.add(gun3);
        guns.add(gun4);
        Player player = new Player(USERNAME, HEALTH);
        player.addGun(gun1);
        player.addGun(gun2);
        player.addGun(gun3);
        player.addGun(gun4);
        Gun[] expectedGuns = guns.toArray(Gun[]::new);
        Gun[] resultGuns = player.getGuns().toArray(Gun[]::new);
        Assert.assertArrayEquals(expectedGuns, resultGuns);
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionWhenAddingGunIfGunIsNull() {
        player.addGun(null);
    }

    @Test
    public void returnExpectedGunByName() {
        String name = "Gun1";
        Gun expectedGun = player.getGuns().stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
        Gun resultGun = player.getGun(name);
        Assert.assertEquals(expectedGun, resultGun);
    }

    @Test(expected = IllegalStateException.class)
    public void throwsExceptionIfPlayerHealthIsBelowZero() {
        player.takeDamage(100);
        player.takeDamage(100);
    }
    @Test
    public void playerLosesProperAmountOfDamage() {
        player.takeDamage(50);
        Assert.assertEquals(50, player.getHealth());
    }

    @Test
    public void playerHealthDropsToZeroIfDamageIsMoreThanHealth(){
        player.takeDamage(150);
        Assert.assertEquals(0, player.getHealth());
    }
}
