package javaAdvanced.definingClasses.exercise.Task6;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).getPokemonCollection().add(new Pokemon(pokemonName, pokemonElement, pokemonHealth));

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String finalCommand = command;
            for (var trainer : trainers.entrySet()) {
                if (trainer.getValue().getPokemonCollection().stream().anyMatch(pokemon -> pokemon.getElement().equals(finalCommand))) {
                    trainer.getValue().setBadges(trainer.getValue().getBadges() + 1);
                } else {
                    trainer.getValue().getPokemonCollection().forEach((Pokemon::removeHP));
                }
                trainer.getValue().setPokemonCollection(trainer.getValue().getPokemonCollection().stream().filter(pokemon -> pokemon.getHealth() > 0).collect(Collectors.toList()));
            }
            command = scanner.nextLine();
        }
        trainers.values().stream().sorted(Comparator.comparing(trainer -> -trainer.getBadges()))
                .forEach(System.out::println);

    }
}
