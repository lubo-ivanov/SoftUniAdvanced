package cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HouseTests {
    House house;

    @Before
    public void createHouse() {
        house = new House("Vilekula", 5);
        house.addCat(new Cat("Pesho1"));
        house.addCat(new Cat("Pesho2"));
        house.addCat(new Cat("Pesho3"));
        house.addCat(new Cat("Pesho4"));
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfNameIsNull() {
        house = new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfNameIsEmpty() {
        house = new House("    ", 10);
    }

    @Test
    public void returnCorrectName() {
        house = new House("Ivan", 10);
        assertEquals("Ivan", house.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionIfCapacityIsBelowZero() {
        house = new House("Ivan", -5);
    }

    @Test
    public void setProperCapacity() {
        house = new House("Ivan", 5);
        assertEquals(5, house.getCapacity());
    }

    @Test
    public void getProperCatCount() {
        assertEquals(4, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenAddingMoreCatsThanCapacity() {
        house.addCat(new Cat("Pesho5"));
        house.addCat(new Cat("Pesho6"));
    }

    @Test
    public void increaseCatCountWhenAdding() {
        assertEquals(4, house.getCount());
        house.addCat(new Cat("Pesho5"));
        assertEquals(5, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWithNonExistingCatName() {
        house.removeCat("Pesho5");
    }


    @Test
    public void removeCatWithCorrectName() {
        assertEquals(4, house.getCount());
        house.removeCat("Pesho1");
        assertEquals(3, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionIfSellingNonExistentCat() {
        house.catForSale("Pesho");
    }

    @Test
    public void setCorrectStateWhenSellingCat() {
        Cat cat = house.catForSale("Pesho1");
        assertFalse(cat.isHungry());
    }


}
