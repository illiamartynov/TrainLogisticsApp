package Railways.HeavyRailwayCar;

import Cargo.ExplosiveItem;
import Data.ExplosiveItemDateGenerator;
import Railways.IDgenerator;

import java.util.ArrayList;
import java.util.List;

public class ExplosivesRailwayCar extends HeavyRailwayCar {

    // fields
    private int cargoCapacity;
    private int numOfItems;
    private List<ExplosiveItem> explosiveItems = new ArrayList<>();


    // constructor
    public ExplosivesRailwayCar(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                                int numberOfSeats, double length, double width, double height,
                                int cargoCapacity, int numOfItems) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height, cargoCapacity, numOfItems);
        setId(IDgenerator.getId());
        this.cargoCapacity = cargoCapacity;
        this.numOfItems = numOfItems;
    }

    // getters and setters


    @Override
    public int getNumOfItems() {
        return numOfItems;
    }

    @Override
    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoVolume() {
        return cargoCapacity * 0.001; // assuming cargo capacity is in liters
    }


    // method to get the type of railway car
    @Override
    public String getType() {
        return "Explosives Railway Car";
    }


    public String toString() {
        return "Explosives Railway Car{" +
                ", shipper='" + getShipper() + '\'' +
                ", securityInformation=" + getSecurityInformation() +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", numberOfSeats=" + getNumberOfSeats() +
                ", id=" + getId() +
                ", length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", explosive items=" + explosiveItems +
                '}';
    }

    // This method calculates the maximum number of explosive items that can be accommodated by the Explosives Railway Car based on its cargo capacity and the volume of the car
    public int calculateExplosive() {
        double volume = super.calculateVolume();
        int maxItems = (int) Math.floor(volume / (cargoCapacity * 0.001));
// If the maximum number of explosive items that can be accommodated is less than the number of explosive items to be loaded, it returns -1 and prints an error message
        if (maxItems < numOfItems) {
            System.err.println("Number of Explosive items is more than the Explosives Railway Car can accommodate ");
            return -1;
        }
        return numOfItems;
    }

    // This method unloads all the explosive items in the Explosives Railway Car and clears the list of explosive items
    @Override
    public void unload() {
        System.out.println("Unloading " + explosiveItems.size() + " explosive items from " + getType());
        explosiveItems.clear();
    }

    // This method loads explosive items into the Explosives Railway Car. It calculates the available free space and loads explosive items accordingly
    @Override
    public void load() {
        int freePlace = calculateExplosive();
        if (freePlace > 0) {
            // If there is free space available, it prints a message indicating the number of explosive items that are being loaded
            System.out.println("Loading " + freePlace + " explosive items into " + getType());
            for (int i = 0; i < freePlace; i++) {
                // It then generates and adds explosive items to the list of explosive items in the car
                explosiveItems.add(ExplosiveItemDateGenerator.generateExplosiveItem());
            }
        } else {
            // If there is no free space available, it prints a message indicating that the Explosives Railway Car is already full and no more explosive items can be loaded
            System.out.println(getType() + " is already full, no more explosive items can be loaded");
        }
    }

}
