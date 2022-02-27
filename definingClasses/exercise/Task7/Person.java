package javaAdvanced.definingClasses.exercise.Task7;

import java.util.List;

public class Person {

    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(Company company, List<Pokemon> pokemons, List<Parent> parents, List<Child> children, Car car) {
        this.company = company;
        this.pokemons = pokemons;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

}
