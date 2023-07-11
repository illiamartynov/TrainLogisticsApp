package Railways.HeavyRailwayCar;

import Cargo.HeavyItem;
import Data.HeavyItemsDataGenerator;
import Railways.IDgenerator;
import Railways.RailwayCar;

import java.util.ArrayList;
import java.util.List;

public class HeavyRailwayCar extends RailwayCar {
    private int cargoCapacity;
    private String cargoType;
    private int maxWeightCapacity;
    private double currentCargoWeight;
    private int numOfItems;
    private List<HeavyItem> heavyItems = new ArrayList<>();


    public HeavyRailwayCar(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                           int numberOfSeats, double length, double width, double height, int cargoCapacity, int numOfItems) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height);
        setId(IDgenerator.getId());
        this.numOfItems = numOfItems;
        this.cargoCapacity = cargoCapacity;
    }


    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }


    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public int getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public void setMaxWeightCapacity(int maxWeightCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
    }

    public double getCurrentCargoWeight() {
        return currentCargoWeight;
    }

    public void setCurrentCargoWeight(double currentCargoWeight) {
        this.currentCargoWeight = currentCargoWeight;
    }


    @Override
    public String getType() {
        return "Heavy Railroad Car";
    }


    @Override
    public String toString() {
        return "Heavy Railroad Car{" +
                "shipper='" + getShipper() + '\'' +
                ", securityInformation=" + getSecurityInformation() +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", numberOfSeats=" + getNumberOfSeats() +
                ", length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", heavy items=" + heavyItems +
                '}';
    }


    // A public method to calculate the maximum number of heavy items that can be loaded in the Heavy Railroad Car based on its volume and cargo capacity
    public int calculateHeavyItems() {
        double volume = super.calculateVolume(); // Calculate the volume of the Heavy Railroad Car using the method inherited from the parent class
        int maxItems = (int) Math.floor(volume / (cargoCapacity * 0.001)); // Calculate the maximum number of heavy items that can be loaded based on the volume and cargo capacity. The capacity is converted from kg to tons.
        if (maxItems < numOfItems) { // If the calculated maximum number of items is less than the requested number of items to be loaded
            System.err.println("Number of heavy items is more than the Heavy Railroad Car can accommodate "); // Print an error message to inform that the number of heavy items exceeds the maximum capacity of the Heavy Railroad Car
            return -1; // Return -1 to indicate that loading is not possible
        }
        return numOfItems;
    }

    // An overridden method to unload all the heavy items from the Heavy Railroad Car and clear its list
    @Override
    public void unload() {
        System.out.println("Unloading " + heavyItems.size() + " heavyItems from " + getType()); // Print a message to inform that the unloading process has started and the number of heavy items to be unloaded and the type of Railroad Car
        heavyItems.clear(); // Clear the list of heavy items in the Heavy Railroad Car
    }

    // An overridden method to load the heavy items into the Heavy Railroad Car based on the available free space
    @Override
    public void load() {
        int freePlace = calculateHeavyItems(); // Calculate the free space in the Heavy Railroad Car using the calculateHeavyItems() method
        if (freePlace > 0) { // If there is available free space in the Heavy Railroad Car
            System.out.println("Loading " + freePlace + " heavy items into " + getType()); // Print a message to inform that the loading process has started and the number of heavy items to be loaded and the type of Railroad Car
            for (int i = 0; i < freePlace; i++) { // Load the number of heavy items into the Heavy Railroad Car based on the available free space
                heavyItems.add(HeavyItemsDataGenerator.generateHeavyItem()); // Generate a new heavy item and add it to the list of heavy items in the Heavy Railroad Car
            }
        } else { // If there is no available free space in the Heavy Railroad Car
            System.out.println(getType() + " is already full, no more heavy items can be loaded"); // Print a message to inform that the Heavy Railroad Car is already full and no more heavy items can be loaded
        }
    }

}