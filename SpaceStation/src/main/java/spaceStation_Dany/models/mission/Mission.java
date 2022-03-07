package spaceStation_Dany.models.mission;

import spaceStation_Dany.models.astronauts.Astronaut;
import spaceStation_Dany.models.planets.Planet;

import java.util.List;

public interface Mission {
    void explore(Planet planet, List<Astronaut> astronauts);
}
