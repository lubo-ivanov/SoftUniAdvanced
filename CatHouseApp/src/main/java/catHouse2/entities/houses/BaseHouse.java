package catHouse2.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.houses.House;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }


    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {

        if (capacity == this.cats.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }

        String catHair = cat.getClass().getSimpleName().replaceAll("hairCat", "");

        if (!this.getClass().getSimpleName().contains(catHair)) {
            throw new IllegalStateException("Unsuitable house.");
        }
        this.cats.add(cat);

    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder build = new StringBuilder(this.name + " " + this.getClass().getSimpleName() + ":" + System.lineSeparator());
        build.append("Cats: ");
        String catNames = this.cats.isEmpty()
                ? "none"
                : cats.stream().map(Cat::getName).collect(Collectors.joining(" "));
        build.append(catNames + System.lineSeparator());
        build.append("Toys: " + this.toys.size() + " Softness: " + sumSoftness());
        return build.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
