package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronauts;
    private Repository<Planet> planets;
    private int exploredPlanets = 0;

    public ControllerImpl() {
        this.astronauts = new AstronautRepository();
        this.planets = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                astronaut = null;
                break;
        }
        if (astronaut == null) {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        } else {
            astronauts.add(astronaut);
            return String.format(ASTRONAUT_ADDED, type, astronautName);
        }

    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        Arrays.stream(items).forEach(planet.getItems()::add);
        planets.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronautToRemove = astronauts.findByName(astronautName);
        if (astronautToRemove == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        } else {
            astronauts.remove(astronautToRemove);
            return String.format(ASTRONAUT_RETIRED, astronautName);
        }
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planetToExplore = planets.findByName(planetName);
        Collection<Astronaut> astronautsCollection = astronauts.getModels().stream().filter(e -> e.getOxygen() > 60).collect(Collectors.toList());
        if (astronautsCollection.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        mission.explore(planetToExplore, astronautsCollection);
        this.exploredPlanets++;
        long deadAstronauts = astronautsCollection.stream().filter(e -> e.getOxygen() == 0).count();
        return String.format(PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, exploredPlanets)).append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        astronauts.getModels().forEach(astronaut -> {
            sb.append(String.format(REPORT_ASTRONAUT_NAME, astronaut.getName())).append(System.lineSeparator());
            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen())).append(System.lineSeparator());
            String itemsString = "none";
            if (!astronaut.getBag().getItems().isEmpty()) {
                itemsString = String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems());
            }
            sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, itemsString)).append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
