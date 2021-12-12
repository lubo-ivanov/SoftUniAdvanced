package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.LinkedHashMap;
import java.util.Map;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Map<String, House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        switch (type) {
            case "ShortHouse":
                this.houses.put(name, new ShortHouse(name));
                return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
            case "LongHouse":
                this.houses.put(name, new LongHouse(name));
                return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
    }

    @Override
    public String buyToy(String type) {
        switch (type) {
            case "Ball":
                toys.buyToy(new Ball());
                return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
            case "Mouse":
                toys.buyToy(new Mouse());
                return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toyToAdd = toys.findFirst(toyType);
        if (toyToAdd != null) {
            this.toys.removeToy(toyToAdd);
            this.houses.get(houseName).buyToy(toyToAdd);
            return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
        }
        throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        String houseType = houses.get(houseName).getClass().getSimpleName();
        Cat catToAdd;
        switch (catType) {
            case "ShorthairCat":
                catToAdd = new ShorthairCat(catName, catBreed, price);
                if (houseType.equals("ShortHouse")) {
                    houses.get(houseName).addCat(catToAdd);
                } else {
                    return UNSUITABLE_HOUSE;
                }
                break;
            case "LonghairCat":
                catToAdd = new LonghairCat(catName, catBreed, price);
                if (houseType.equals("LongHouse")) {
                    houses.get(houseName).addCat(catToAdd);
                } else {
                    return UNSUITABLE_HOUSE;
                }
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        this.houses.get(houseName).feeding();
        return String.format(FEEDING_CAT, this.houses.get(houseName).getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        double totalPrice = 0;
        House house = this.houses.get(houseName);
        totalPrice += house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        totalPrice += house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        return String.format(VALUE_HOUSE, houseName, totalPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house : houses.values()) {
            sb.append(house.getStatistics()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
