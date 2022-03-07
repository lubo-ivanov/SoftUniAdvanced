package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            List<String> itemsToRemove = new ArrayList<>();
            planet.getItems().forEach(item -> {
                if (astronaut.canBreath()) {
                    astronaut.breath();
                    astronaut.getBag().getItems().add(item);
                    itemsToRemove.add(item);
                }
            });
            itemsToRemove.forEach(planet.getItems()::remove);
        }
    }
}



