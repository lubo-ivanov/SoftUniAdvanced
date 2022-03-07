package restaurant_Dany.entities.tables.interfaces;

import restaurant_Dany.entities.drinks.interfaces.Beverages;
import restaurant_Dany.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant_Dany.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        this.setSize(size);
        this.numberOfPeople = 0;
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
        this.allPeople = 0.0;
    }



    private void setSize(int size) {
        // <= 0 or < 0
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        return numberOfPeople * pricePerPerson;
    }

    @Override
    public void clear() {
        this.beverages.clear();
        this.healthyFood.clear();
        this.isReservedTable = false;
        //this.numberOfPeople = 0;
    }

    @Override
    public String tableInformation() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("Table - %d", this.number))
                .append(System.lineSeparator())
                .append(String.format("Size - %d", this.size))
                .append(System.lineSeparator())
                .append(String.format("Type - %s", this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("All price - %.2f", this.bill()))
                .append(System.lineSeparator());
        return info.toString().trim();
    }
}
