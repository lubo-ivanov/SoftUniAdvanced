package catHouse2.core;

import catHouse.core.Controller;
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

import static catHouse.common.ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE;
import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Map<String,House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house  = null;
        switch (type){
            case"ShortHouse":
                house = new ShortHouse(name);
                break;
            case"LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.put(name,house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE,type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;
        switch (type){
            case"Ball":
                toy = new Ball();
                break;
            case"Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE,type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy byType = this.toys.findFirst(toyType);
        if(byType == null){
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND,toyType));
        }
        this.houses.get(houseName).buyToy(byType);
        this.toys.removeToy(byType);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE,toyType,houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = null;
        switch (catType){
            case"ShorthairCat":
                cat = new ShorthairCat(catName,catBreed,price);
                break;
            case"LonghairCat":
                cat = new LonghairCat(catName,catBreed,price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        try {
            House house = houses.get(houseName);
            house.addCat(cat);
        } catch (IllegalStateException e){
            return e.getMessage();
        }
        String returning = String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE,catType,houseName);
        return returning;

    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses.get(houseName);
        house.feeding();
        return String.format(FEEDING_CAT,house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses.get(houseName);
        double toysSum = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double catSum = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        return String.format(VALUE_HOUSE,house.getName(),toysSum + catSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder build = new StringBuilder();
        for (House s : houses.values()) {
            build.append(s.getStatistics()+ System.lineSeparator());
        }
        return build.toString().trim();
    }
}
