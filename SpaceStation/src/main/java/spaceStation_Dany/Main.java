package spaceStation_Dany;

import spaceStation_Dany.core.Controller;
import spaceStation_Dany.core.ControllerImpl;
import spaceStation_Dany.core.Engine;
import spaceStation_Dany.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
