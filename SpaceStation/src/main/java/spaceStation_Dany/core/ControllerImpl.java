package spaceStation_Dany.core;

import spaceStation_Dany.models.astronauts.*;
import spaceStation_Dany.models.mission.Mission;
import spaceStation_Dany.models.mission.MissionImpl;
import spaceStation_Dany.models.planets.Planet;
import spaceStation_Dany.models.planets.PlanetImpl;
import spaceStation_Dany.repositories.AstronautRepository;
import spaceStation_Dany.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation_Dany.common.ConstantMessages.*;
import static spaceStation_Dany.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int exploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
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
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(Arrays.asList(items));
        this.planetRepository.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.getModels()
                .stream()
                .filter(a -> a.getName().equals(astronautName))
                .findFirst()
                .orElse(null);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> suitableAstronauts = astronautRepository.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        int countBeforeMission = suitableAstronauts.size();
        Mission mission = new MissionImpl();
        Planet planet = this.planetRepository.findByName(planetName);
        mission.explore(planet, suitableAstronauts);
        int countAfterMission = suitableAstronauts.size();
        exploredPlanets++;

        return String.format(PLANET_EXPLORED, planetName, countBeforeMission - countAfterMission);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, exploredPlanets)).append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        astronautRepository.getModels().stream()
                .forEach(a -> {
                    sb.append(String.format(REPORT_ASTRONAUT_NAME, a.getName())).append(System.lineSeparator())
                            .append(String.format(REPORT_ASTRONAUT_OXYGEN, a.getOxygen())).append(System.lineSeparator());
                    if (a.getBag().getItems().size() == 0) {
                        sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());
                    } else {
                        sb.append("Bag items: " + String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, a.getBag().getItems()))
                                .append(System.lineSeparator());
                    }
                });
        return sb.toString().trim();
    }
}
