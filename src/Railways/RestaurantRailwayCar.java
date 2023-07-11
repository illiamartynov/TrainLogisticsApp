package Railways;

import Cargo.Dish;
import Data.DishDataGenerator;
import Interfaces.Electricity;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRailwayCar extends RailwayCar implements Electricity{

    private List<Dish> dishes = new ArrayList<>();
    private int numMeals;
    private int mealsVolume;


    // constructor
    public RestaurantRailwayCar(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                                int numberOfSeats, double length, double width, double height, int numMeals, int mealsVolume) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height);
        setId(IDgenerator.getId());
        this.numMeals = numMeals;
        this.mealsVolume = mealsVolume;
        setRequiresElectricalConnection(true);
    }


    public int getNumMeals() {
        return numMeals;
    }

    public void setNumMeals(int numMeals) {
        this.numMeals = numMeals;
    }

    public int getMealsVolume() {
        return mealsVolume;
    }

    public void setMealsVolume(int mealsVolume) {
        this.mealsVolume = mealsVolume;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public int calculateMeals()  {
        double volume = super.calculateVolume();
        int maxMeals = (int) Math.floor(volume / (mealsVolume * 0.001));
        if (maxMeals < numMeals) {
            System.err.println("Number of dishes is more than the Railway Post Office can accommodate ");
            return -1;
        }
        return Math.min(maxMeals, numMeals);
    }

    @Override
    public String getType() {
        return "Restaurant Railway Car";
    }

    @Override
    public void unload() {
        System.out.println("Unloading " + dishes.size() + " dishes from " + getType());
        dishes.clear();
    }

    @Override
    public void load() {
        int availableSeats = calculateMeals();
        if (availableSeats > 0) {
            System.out.println("Loading " + availableSeats + " dishes into " + getType());
            for (int i = 0; i < availableSeats; i++) {
                dishes.add(DishDataGenerator.generateDish());
            }
        } else {
            System.out.println(getType() + " is already full, no more dishes can be loaded");
        }
    }

    @Override
    public boolean requiresElectricity() {
        return true;
    }


    @Override
    public String toString() {
        return "PassengerRailwayCar{" +
                "shipper='" + getShipper() + '\'' +
                ", securityInformation=" + getSecurityInformation() +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", numberOfSeats=" + getNumberOfSeats() +
                ", length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", dishes=" + dishes +
                '}';
    }
}