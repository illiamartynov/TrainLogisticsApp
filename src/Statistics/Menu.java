package Statistics;

import Graph.*;
import Locomotive.Locomotive;
import Railways.*;
import Railways.HeavyRailwayCar.ExplosivesRailwayCar;
import Railways.HeavyRailwayCar.HeavyRailwayCar;
import Railways.HeavyRailwayCar.ToxicRailwayCar;
import Railways.basicRailwaycar.BasicRailwayCar;
import Railways.basicRailwaycar.GaseousRailwayCar;
import Railways.basicRailwaycar.LiquidRailwayCar;
import Railways.basicRailwaycar.RefrigeratedRailwayCar;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Locomotive> locomotives = new ArrayList<>();
Statistic stat = new Statistic();
AppState appState = new AppState();
private Graph graph;
    private Scanner scanner;

    public Menu() {
        graph = MapOfUkraine.mapping();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        System.out.println("Welcome to the Locomotive program!");
        boolean programRunning = true;

        while (programRunning) {
            System.out.println("Select an option:");
            System.out.println("1. Create Locomotive");
            System.out.println("2. Add Railway Car");
            System.out.println("3. Start Program");
            System.out.println("4. End Program");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createLocomotive();
                    break;
                case 2:
                    addRailwayCar();
                    break;
                case 3:
                    startProgram();
                    break;
                case 4:
                    programRunning = false;
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
            if (option == 4) {
                break;
            }
        }
    }

    private void createLocomotive() {
        System.out.println("Enter Locomotive name:");
        String name = scanner.nextLine();
        System.out.println("Enter start Station:");
        String startStation = scanner.nextLine();
        System.out.println("Enter end Station:");
        String endStation = scanner.nextLine();

        if (!graph.containsKey(startStation) || !graph.containsKey(endStation)) {
            System.out.println("Start or end station not found in mapOfUkraine. Locomotive not created.");
            return;
        }

        System.out.println("Enter Base Station:");
        String baseStation = scanner.nextLine();
        System.out.println("Enter Max Weight Capacity:");
        double maxWeightCapacity = scanner.nextDouble();
        System.out.println("Enter Max Carriage Count:");
        int maxCarriageCount = scanner.nextInt();
        System.out.println("Enter Max Electrified Cars Count:");
        int maxElectrifiedCarsCount = scanner.nextInt();
        scanner.nextLine();

        Locomotive locomotive = new Locomotive(name, baseStation, startStation, endStation, maxWeightCapacity, maxCarriageCount, maxElectrifiedCarsCount, graph);

        locomotives.add(locomotive);
        System.out.println("Locomotive created.");
    }

    private void addRailwayCar() {

        int count = 0;

        if(locomotives.size() == 0 ){
            return;
        }

        System.out.println("To which locomotive you want to add railway car?");
        for (Locomotive lc : locomotives) {
            System.out.println(count++ + " " + lc.getNameLoc());
        }

        int numberLocomotive = scanner.nextInt();
        if (numberLocomotive < 0 || numberLocomotive >= locomotives.size()){
            System.out.println("Invalid locomotive number. Locomotive not found.");
            return;
        }
        System.out.println("Choose the type of railway car you want to add to locomotive which number is " + numberLocomotive);
        System.out.println("1.Railway car for passengers");
        System.out.println("2.Railway car for Baggage");
        System.out.println("3.Railway car for Post");
        System.out.println("4.Railway car for Restaurant");
        System.out.println("5.Railway car for Basic railway car");
        System.out.println("6.Railway car for Gaseous");
        System.out.println("7.Railway car for Liquids");
        System.out.println("8.Railway car for Refrigerator");
        System.out.println("9.Railway car for Heavy railway car");
        System.out.println("10.Railway car for Explosives");
        System.out.println("11.Railway car for Toxic items");
        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                return;
            case 1:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                String name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                boolean securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                double netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                double grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                int numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                double length = scanner.nextDouble();
                System.out.println("Enter width:");
                double width = scanner.nextDouble();
                System.out.println("Enter height:");
                double height = scanner.nextDouble();
                PassengerRailwayCar passengers = new PassengerRailwayCar(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height);
                locomotives.get(numberLocomotive).addRailwayCar(passengers);
                break;

            case 2:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                length = scanner.nextDouble();
                System.out.println("Enter width:");
                width = scanner.nextDouble();
                System.out.println("Enter height:");
                height = scanner.nextDouble();
                System.out.println("Enter number of lockers:");
                int numLockers = scanner.nextInt();
                System.out.println("Enter locker capacity:");
                int lockerCapacity = scanner.nextInt();
                scanner.nextLine();
                RailwayBaggage railwayBaggage = new RailwayBaggage(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height, numLockers, lockerCapacity);
                locomotives.get(numberLocomotive).addRailwayCar(railwayBaggage);
                break;
            case 3:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                length = scanner.nextDouble();
                System.out.println("Enter width:");
                width = scanner.nextDouble();
                System.out.println("Enter height:");
                height = scanner.nextDouble();
                System.out.println("Enter number of mailboxes:");
                int numMailboxes = scanner.nextInt();
                System.out.println("Enter mailbox capacity:");
                int mailboxCapacity = scanner.nextInt();
                scanner.nextLine();
                RailwayPostOffice railwayPostOffice = new RailwayPostOffice(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height, numMailboxes, mailboxCapacity);
                locomotives.get(numberLocomotive).addRailwayCar(railwayPostOffice);
                break;
            case 4:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                length = scanner.nextDouble();
                System.out.println("Enter width:");
                width = scanner.nextDouble();
                System.out.println("Enter height:");
                height = scanner.nextDouble();
                System.out.println("Enter number of meals:");
                int numMeals = scanner.nextInt();
                System.out.println("Enter meals capacity:");
                int mealsVolume = scanner.nextInt();
                scanner.nextLine();
                RestaurantRailwayCar restaurant = new RestaurantRailwayCar(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height, numMeals, mealsVolume);
                locomotives.get(numberLocomotive).addRailwayCar(restaurant);
                break;
            case 5:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                length = scanner.nextDouble();
                System.out.println("Enter width:");
                width = scanner.nextDouble();
                System.out.println("Enter height:");
                height = scanner.nextDouble();
                System.out.println("Enter cargo capacity:");
                int cargoCapacity = scanner.nextInt();
                System.out.println("Enter number of cargo:");
                int numCargo = scanner.nextInt();
                scanner.nextLine();
                BasicRailwayCar basic = new BasicRailwayCar(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height, cargoCapacity, numCargo);
                locomotives.get(numberLocomotive).addRailwayCar(basic);
                break;
            case 6:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                length = scanner.nextDouble();
                System.out.println("Enter width:");
                width = scanner.nextDouble();
                System.out.println("Enter height:");
                height = scanner.nextDouble();
                System.out.println("Enter gas capacity:");
                int gasCapacity = scanner.nextInt();
                System.out.println("Enter number of gases:");
                int numGases = scanner.nextInt();
                scanner.nextLine();
                GaseousRailwayCar gases = new GaseousRailwayCar(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height, gasCapacity, numGases);
                locomotives.get(numberLocomotive).addRailwayCar(gases);
                break;
            case 7:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                 securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                 netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                 grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                 length = scanner.nextDouble();
                System.out.println("Enter width:");
                 width = scanner.nextDouble();
                System.out.println("Enter height:");
                 height = scanner.nextDouble();
                System.out.println("Enter number of liquids:");
                int numOfLiquid = scanner.nextInt();
                System.out.println("Enter liquid capacity:");
                int liquidCapacity = scanner.nextInt();
                scanner.nextLine();
                LiquidRailwayCar liquidRailwayCar = new LiquidRailwayCar(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height, liquidCapacity, numOfLiquid);
                locomotives.get(numberLocomotive).addRailwayCar(liquidRailwayCar);
                break;

            case 8:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                length = scanner.nextDouble();
                System.out.println("Enter width:");
                width = scanner.nextDouble();
                System.out.println("Enter height:");
                height = scanner.nextDouble();
                System.out.println("Enter number of cargo:");
                int cargoCapacity1 = scanner.nextInt();
                System.out.println("Enter cargo capacity:");
                int numCargo1 = scanner.nextInt();
                scanner.nextLine();
                RefrigeratedRailwayCar refrigeratedRailwayCar = new RefrigeratedRailwayCar(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height, cargoCapacity1, numCargo1);
                locomotives.get(numberLocomotive).addRailwayCar(refrigeratedRailwayCar);
                break;
            case 9:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                length = scanner.nextDouble();
                System.out.println("Enter width:");
                width = scanner.nextDouble();
                System.out.println("Enter height:");
                height = scanner.nextDouble();
                System.out.println("Enter number of cargo:");
                int cargoCapacity2 = scanner.nextInt();
                System.out.println("Enter cargo capacity:");
                int numOfItems = scanner.nextInt();
                scanner.nextLine();
                HeavyRailwayCar heavyRailwayCar = new HeavyRailwayCar(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height, cargoCapacity2, numOfItems);
                locomotives.get(numberLocomotive).addRailwayCar(heavyRailwayCar);
                break;
            case 10:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                length = scanner.nextDouble();
                System.out.println("Enter width:");
                width = scanner.nextDouble();
                System.out.println("Enter height:");
                height = scanner.nextDouble();
                System.out.println("Enter number of explosive items:");
                int cargoExplosives = scanner.nextInt();
                System.out.println("Enter explosive items capacity:");
                int numOfExplosives = scanner.nextInt();
                scanner.nextLine();
                ExplosivesRailwayCar explosivesRailwayCar = new ExplosivesRailwayCar(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height, cargoExplosives, numOfExplosives);
                locomotives.get(numberLocomotive).addRailwayCar(explosivesRailwayCar);
                break;
            case 11:
                System.out.println("Enter railway car shipper:");
                scanner.nextLine(); // Consume the newline character
                name = scanner.nextLine();
                System.out.println("Does your railway car has security information? (true, false):");
                securityInf = scanner.nextBoolean();
                System.out.println("Enter net weight:");
                netWeight = scanner.nextDouble();
                System.out.println("Enter gross weight:");
                grossWeight = scanner.nextDouble();
                System.out.println("Enter number of seats:");
                numberOfSeats = scanner.nextInt();
                System.out.println("Enter length:");
                length = scanner.nextDouble();
                System.out.println("Enter width:");
                width = scanner.nextDouble();
                System.out.println("Enter height:");
                height = scanner.nextDouble();
                System.out.println("Enter number of toxic items:");
                int cargoToxic = scanner.nextInt();
                System.out.println("Enter toxic items capacity:");
                int numToxic = scanner.nextInt();
                scanner.nextLine();
                ToxicRailwayCar toxicRailwayCar = new ToxicRailwayCar(name, securityInf, netWeight, grossWeight, numberOfSeats, length, width, height, cargoToxic, numToxic);
                locomotives.get(numberLocomotive).addRailwayCar(toxicRailwayCar);
                break;

        }

        System.out.println("Railway car added successfully!");
    }




    private void startProgram() {
        System.out.println("Program started");
        for (Locomotive locomotive : locomotives) {
            locomotive.start();
            Statistic.addStatistics(locomotive);

            AppState.addStatistics(locomotive);


        }
        stat.start();
        appState.start();
    }
}
