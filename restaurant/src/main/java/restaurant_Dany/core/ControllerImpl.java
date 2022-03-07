package restaurant_Dany.core;

import restaurant_Dany.core.interfaces.Controller;
import restaurant_Dany.entities.drinks.interfaces.Fresh;
import restaurant_Dany.entities.drinks.interfaces.Smoothie;
import restaurant_Dany.entities.healthyFoods.interfaces.HealthyFood;
import restaurant_Dany.entities.drinks.interfaces.Beverages;
import restaurant_Dany.entities.healthyFoods.interfaces.Salad;
import restaurant_Dany.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant_Dany.entities.tables.interfaces.InGarden;
import restaurant_Dany.entities.tables.interfaces.Indoors;
import restaurant_Dany.entities.tables.interfaces.Table;
import restaurant_Dany.repositories.interfaces.*;

import static restaurant_Dany.common.ExceptionMessages.*;
import static restaurant_Dany.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double finalSum = 0;


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = null;
        if (type.equals("Salad")) {
            food = new Salad(name, price);
        } else if (type.equals("VeganBiscuits")) {
            food = new VeganBiscuits(name, price);
        }
        HealthyFood repoFood = this.healthFoodRepository.foodByName(name);
        if (repoFood != null) {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }

        this.healthFoodRepository.add(food);
        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage = null;
        if (type.equals("Fresh")) {
            beverage = new Fresh(name, counter, brand);
        } else if (type.equals("Smoothie")) {
            beverage = new Smoothie(name, counter, brand);
        }
        Beverages repoBeverage = this.beverageRepository.beverageByName(name, brand);
        if (repoBeverage != null) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }

        this.beverageRepository.add(beverage);
        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;
        if (type.equals("Indoors")) {
            table = new Indoors(tableNumber, capacity);
        } else if (type.equals("InGarden")) {
            table = new InGarden(tableNumber, capacity);
        }
        Table tableRepo = this.tableRepository.byNumber(tableNumber);
        if (tableRepo != null) {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, tableNumber));
        }
        this.tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = this.tableRepository.getAllEntities().stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst()
                .orElse(null);
        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        this.tableRepository.byNumber(table.getTableNumber()).reserve(numberOfPeople);

        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = this.tableRepository.byNumber(tableNumber);
        HealthyFood healthyFood = this.healthFoodRepository.foodByName(healthyFoodName);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        } else if (healthyFood == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        this.tableRepository.byNumber(tableNumber).orderHealthy(healthyFood);
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = this.tableRepository.byNumber(tableNumber);
        Beverages beverage = this.beverageRepository.beverageByName(name, brand);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        } else if (beverage == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }
        this.tableRepository.byNumber(tableNumber).orderBeverages(beverage);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = this.tableRepository.byNumber(tableNumber);
        finalSum += table.bill();

        this.tableRepository.byNumber(tableNumber).clear();


        return String.format(BILL, table.getTableNumber(), table.bill());
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, finalSum);
    }
}
