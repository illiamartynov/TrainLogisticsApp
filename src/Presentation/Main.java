package Presentation;

import Graph.*;
import Locomotive.Locomotive;
import Railways.HeavyRailwayCar.ExplosivesRailwayCar;
import Railways.HeavyRailwayCar.HeavyRailwayCar;
import Railways.HeavyRailwayCar.ToxicRailwayCar;
import Railways.*;
import Railways.basicRailwaycar.BasicRailwayCar;
import Railways.basicRailwaycar.GaseousRailwayCar;
import Railways.basicRailwaycar.LiquidRailwayCar;
import Railways.basicRailwaycar.RefrigeratedRailwayCar;
import Statistics.AppState;
import Statistics.Menu;
import Statistics.Statistic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static Graph.MapOfUkraine.mapping;


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
        Statistic stat = new Statistic();
        AppState appState = new AppState();
        Graph graph;
        graph = mapping();


        List<RailwayCar> railwayCars = new ArrayList<>();
        PassengerRailwayCar passengerRailwayCar = new PassengerRailwayCar("XYZ", true, 3000.0, 5000.0, 50, 25.0, 12.0, 10.0);
        railwayCars.add(passengerRailwayCar);
        RailwayBaggage railwayBaggage = new RailwayBaggage("XYZ", true, 1000.0, 2000.0, 50, 30.0, 10.0, 5.0, 8, 50);
        railwayCars.add(railwayBaggage);
        RailwayPostOffice railwayPostOffice = new RailwayPostOffice("ABC Company", false, 2000.0, 3000.0, 100, 40.0, 15.0, 10.0, 50, 100);
        railwayCars.add(railwayPostOffice);
        RestaurantRailwayCar restaurantRailwayCar = new RestaurantRailwayCar("ABC", true, 5000.0, 6000.0, 20, 40.0, 15.0, 10.0, 12, 100);
        railwayCars.add(restaurantRailwayCar);
        BasicRailwayCar basicRailwayCar = new BasicRailwayCar("ABC Company", true, 2000.0, 3000.0, 0, 20.0, 10.0, 5.0, 100, 50);
        railwayCars.add(basicRailwayCar);
        GaseousRailwayCar gaseousRailwayCar = new GaseousRailwayCar("ABC Company", true, 1000, 1200, 10, 15, 3, 4, 100, 80);
        railwayCars.add(gaseousRailwayCar);
        LiquidRailwayCar liquidCar = new LiquidRailwayCar("ABC Corp", true, 20000.0, 20000.0, 50, 20.0, 4, 6, 10, 15);
        railwayCars.add(liquidCar);
        RefrigeratedRailwayCar refrigeratorRailwayCar = new RefrigeratedRailwayCar("Fruit Co.", true, 20000.0, 30000.0, 80, 20.0, 3.5, 4.5, 100, 80);
        railwayCars.add(refrigeratorRailwayCar);
        ExplosivesRailwayCar explosivesRailwayCar = new ExplosivesRailwayCar("US Military", true, 15000.0, 30000.0, 0, 15.0, 2.5, 2.5, 500, 15);
        railwayCars.add(explosivesRailwayCar);
        HeavyRailwayCar heavyRailwayCar = new HeavyRailwayCar("ABC Corp", true, 1000.0, 1200.0, 20, 10.0, 2.5, 3.0, 5000, 10);
        railwayCars.add(heavyRailwayCar);
        ToxicRailwayCar toxicRailwayCar = new ToxicRailwayCar("ACME Inc.", true, 35000, 45000, 50, 20.5, 3.2, 4.2, 2000, 100);
        railwayCars.add(toxicRailwayCar);


        List<Locomotive> locomotives = new ArrayList<>();
        locomotives.add(new Locomotive("Loc1", "Kyiv", "Odessa", "Kamianets-Podilskyi", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc2", "Kyiv", "Lviv", "Kyiv", 200000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc3", "Kyiv", "Krasyliv", "Berdyansk", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc4", "Kyiv", "Pripyat", "Yevpatoria", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc5", "Kyiv", "Horlivka", "Dnipro", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc6", "Kyiv", "Berdyansk", "Drohobych", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc7", "Kyiv", "Brovary", "Enerhodar", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc8", "Kyiv", "Alchevsk", "Balta", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc9", "Kyiv", "Enerhodar", "Luhansk", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc10", "Kyiv", "Kremenchuk", "Konotop", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc11", "Kyiv", "Nyzhyn", "Izmail", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc12", "Kyiv", "Konotop", "Dnipro", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc13", "Kyiv", "Zmiiv", "Dnipro", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc14", "Kyiv", "Yalta", "Bohuslav", 20000000, 5, 2, graph));
        locomotives.add(new Locomotive("Loc15", "Kyiv", "Dnipro", "Lanivtsi", 20000000, 5, 2, graph));


        Random rand = new Random();

        Collections.shuffle(railwayCars);
        int numCarsToAdd = 2; // add 2 RailwayCars to each Locomotive.Locomotive

        for (Locomotive loco : locomotives) {
            loco.start();
            Statistic.addStatistics(loco);
            AppState.addStatistics(loco);
            for (int i = 0; i < numCarsToAdd; i++) {
                if (!railwayCars.isEmpty()) {
                    int randomIndex = rand.nextInt(railwayCars.size());
                    loco.addRailwayCar(railwayCars.get(randomIndex));
                } else {
                    break; // no more RailwayCars left to add
                }
            }
        }

        stat.start();
        appState.start();
    }
}