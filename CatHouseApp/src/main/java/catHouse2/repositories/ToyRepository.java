package catHouse2.repositories;

import catHouse.entities.toys.Toy;
import catHouse.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository {
    Collection<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return this.toys.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {

        return this.toys.stream().filter(d -> d.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}
