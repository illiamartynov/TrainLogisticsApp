package Presentation;

import Graph.*;
import Locomotive.Locomotive;
import Railways.HeavyRailwayCar.ExplosivesRailwayCar;
import Railways.HeavyRailwayCar.HeavyRailwayCar;
import Railways.HeavyRailwayCar.ToxicRailwayCar;
import Railways.PassengerRailwayCar;
import Railways.RailwayBaggage;
import Railways.RailwayPostOffice;
import Railways.RestaurantRailwayCar;
import Railways.basicRailwaycar.BasicRailwayCar;
import Railways.basicRailwaycar.GaseousRailwayCar;
import Railways.basicRailwaycar.LiquidRailwayCar;
import Railways.basicRailwaycar.RefrigeratedRailwayCar;
import Statistics.AppState;
import Statistics.Statistic;

import static Graph.MapOfUkraine.mapping;

public class Presentation {
        public static void main(String[] args) throws Exception {
            Graph graph;
            graph = mapping();


//---------------------------------------------------------------- CREATING MENU -----------------------------------------------------------------------------
//        Statistics.Menu menu = new Statistics.Menu();
//        menu.menu();

//---------------------------------------------------------------- CREATING LOCOMOTIVE -----------------------------------------------------------------------------
        Locomotive lc1 = new Locomotive("Locomotive 1", "Kyiv", "Lviv", "Odessa", 200000, 6, 3, graph);
        Locomotive lc2 = new Locomotive("Locomotive 2", "Kyiv", "Lviv", "Odessa", 200000, 6, 3, graph);



//---------------------------------------------------------------- CREATING RAILWAY CARS -----------------------------------------------------------------------------


        PassengerRailwayCar passengerRailwayCar = new PassengerRailwayCar("XYZ", true, 3000.0, 5000.0, 50, 25.0, 12.0, 10.0);
        RailwayBaggage railwayBaggage = new RailwayBaggage("XYZ", true, 1000.0, 2000.0, 50, 30.0, 10.0, 5.0, 8, 50);
        RailwayPostOffice railwayPostOffice = new RailwayPostOffice("ABC Company", false, 2000.0, 3000.0, 100, 40.0, 15.0, 10.0, 50, 100);
        RestaurantRailwayCar restaurantRailwayCar = new RestaurantRailwayCar("ABC", true, 5000.0, 6000.0, 20, 40.0, 15.0, 10.0, 12, 100);
        BasicRailwayCar basicRailwayCar = new BasicRailwayCar("ABC Company", true, 2000.0, 3000.0, 0, 20.0, 10.0, 5.0, 100, 50);
        GaseousRailwayCar gaseousRailwayCar = new GaseousRailwayCar("ABC Company", true, 1000, 1200, 10, 15, 3, 4, 100, 80);
        LiquidRailwayCar liquidCar = new LiquidRailwayCar("ABC Corp", true, 20000.0, 20000.0, 50, 20.0, 4, 6, 10, 15);
        RefrigeratedRailwayCar refrigeratorRailwayCar = new RefrigeratedRailwayCar("Fruit Co.", true, 20000.0, 30000.0, 80, 20.0, 3.5, 4.5, 100, 80);
        ExplosivesRailwayCar explosivesRailwayCar = new ExplosivesRailwayCar("US Military", true, 15000.0, 30000.0, 0, 15.0, 2.5, 2.5, 500, 15);
        HeavyRailwayCar heavyRailwayCar = new HeavyRailwayCar("ABC Corp", true, 1000.0, 1200.0, 20, 10.0, 2.5, 3.0, 5000, 10);
        ToxicRailwayCar toxicRailwayCar = new ToxicRailwayCar("ACME Inc.", true, 35000, 45000, 50, 20.5, 3.2, 4.2, 2000, 100);




//---------------------------------------------------------------- ADDING RAILWAY CARS -----------------------------------------------------------------------------

        lc1.addRailwayCar(passengerRailwayCar);
        lc1.addRailwayCar(railwayBaggage);
        lc1.addRailwayCar(railwayPostOffice);
        lc1.removeRailwayCar(passengerRailwayCar);

        lc2.addRailwayCar(restaurantRailwayCar);
        lc2.addRailwayCar(gaseousRailwayCar);
        lc2.addRailwayCar(explosivesRailwayCar);


//---------------------------------------------------------------- ADDING LOCOMOTIVES TO STATISTIC AND START PROGRAMME -----------------------------------------------------------------------------
        Statistic stat = new Statistic();
        AppState appState = new AppState();

        Statistic.addStatistics(lc1);
        Statistic.addStatistics(lc2);
        AppState.addStatistics(lc1);
        AppState.addStatistics(lc2);

        stat.start();
        appState.start();

        lc1.start();
        lc2.start();
        }
}
