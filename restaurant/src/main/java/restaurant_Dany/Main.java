package restaurant_Dany;

import restaurant_Dany.core.ControllerImpl;
import restaurant_Dany.core.EngineImpl;
import restaurant_Dany.core.interfaces.Controller;
import restaurant_Dany.entities.drinks.interfaces.Beverages;
import restaurant_Dany.entities.healthyFoods.interfaces.HealthyFood;
import restaurant_Dany.entities.tables.interfaces.Table;

import restaurant_Dany.io.ConsoleReader;
import restaurant_Dany.io.ConsoleWriter;
import restaurant_Dany.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {
        // TODO: Optional - Create new instances for all repositories to test your code locally.

        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();


        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
