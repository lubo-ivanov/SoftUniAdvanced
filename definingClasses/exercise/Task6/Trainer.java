package javaAdvanced.definingClasses.exercise.Task6;

import java.util.ArrayList;
import java.util.List;


public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonCollection;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemonCollection = new ArrayList<>();
    }

    public List<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public void setPokemonCollection(List<Pokemon> pokemonCollection) {
        this.pokemonCollection = pokemonCollection;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemonCollection.size());
    }
}
