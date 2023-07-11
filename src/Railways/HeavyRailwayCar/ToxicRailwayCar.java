package Railways.HeavyRailwayCar;

import Cargo.ToxicItems;
import Data.ToxicItemsDataGenerator;
import Railways.IDgenerator;

import java.util.ArrayList;
import java.util.List;

public class ToxicRailwayCar extends HeavyRailwayCar {
    // fields

    private int numOfItems;
    private int cargoCapacity;
    private List<ToxicItems> toxicItems = new ArrayList<>();


    // constructor
    public ToxicRailwayCar(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                           int numberOfSeats, double length, double width, double height,
                           int cargoCapacity, int numOfItems) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height, cargoCapacity, numOfItems);
        setId(IDgenerator.getId());
        this.cargoCapacity = cargoCapacity;
        this.numOfItems = numOfItems;
    }

    // getters and setters
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }


    // method to get the type of railway car
    @Override
    public String getType() {
        return "Toxic Railway Car";
    }


    @Override
    public String toString() {
        return "Toxic Railway Car{" +
                "shipper='" + getShipper() + '\'' +
                ", securityInformation=" + getSecurityInformation() +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", numberOfSeats=" + getNumberOfSeats() +
                ", length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", toxic items=" + toxicItems +
                '}';
    }

    // Define a public method called 'calculateToxicItems' that returns an integer value.
    public int calculateToxicItems() {
// Calculate the volume of the railway car.
        double volume = super.calculateVolume();
// Calculate the maximum number of toxic items that can be loaded into the railway car based on its cargo capacity.
        int maxMeals = (int) Math.floor(volume / (cargoCapacity * 0.001));
// Check if the maximum number of toxic items is less than the actual number of toxic items that need to be loaded.
        if (maxMeals < numOfItems) {
// Print an error message indicating that the toxic items cannot be loaded due to insufficient space in the railway car.
            System.err.println("Number of toxic items is more than the Toxic Railway Car can accommodate ");
// Return -1 to indicate that no toxic items were loaded.
            return -1;
        }
// Return the number of toxic items to be loaded.
        return numOfItems;
    }

    // Define an 'unload' method to remove all toxic items from the railway car.
    @Override
    public void unload() {
        // Print a message indicating the number of toxic items being unloaded and the type of railway car.
        System.out.println("Unloading " + toxicItems.size() + " toxic items from " + getType());
        // Remove all toxic items from the railway car.
        toxicItems.clear();
    }

    // Define a 'load' method to load toxic items into the railway car.
    @Override
    public void load() {
        // Determine the number of free slots available for toxic items in the railway car.
        int freePlace = calculateToxicItems();
        // If there is at least one free slot available, load toxic items into the railway car.
        if (freePlace > 0) {
            // Print a message indicating the number of toxic items being loaded and the type of railway car.
            System.out.println("Loading " + freePlace + " toxic items into " + getType());
            // Generate the specified number of toxic items and add them to the railway car.
            for (int i = 0; i < freePlace; i++) {
                toxicItems.add(ToxicItemsDataGenerator.generateToxicItem());
            }
        } else {
            // If there is no free slot available, print a message indicating that no more toxic items can be loaded.
            System.out.println(getType() + " is already full, no more toxic items can be loaded");
        }
    }


}
