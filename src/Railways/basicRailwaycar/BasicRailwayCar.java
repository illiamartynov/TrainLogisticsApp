package Railways.basicRailwaycar;


import Cargo.BasicItem;
import Data.BasicItemsDataGenerator;
import Railways.IDgenerator;
import Railways.RailwayCar;

import java.util.ArrayList;
import java.util.List;

public class BasicRailwayCar extends RailwayCar {
    // fields
    private int cargoCapacity;
    private int numCargo;
    private List<BasicItem> basicItems = new ArrayList<>();


    // constructor
    public BasicRailwayCar(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                           int numberOfSeats, double length, double width, double height, int cargoCapacity, int numCargo) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height);
        setId(IDgenerator.getId());
        this.cargoCapacity = cargoCapacity;
        this.numCargo = numCargo;
    }



    // getters and setters


    public int getNumCargo() {
        return numCargo;
    }

    public void setNumCargo(int numCargo) {
        this.numCargo = numCargo;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }



    // method to get the type of railway car
    @Override
    public String getType() {
        return "Basic Railway Car";
    }

    public String toString() {
        return "Basic Railway Car{" +
                ", shipper='" + getShipper() + '\'' +
                ", securityInformation=" + getSecurityInformation() +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", numberOfSeats=" + getNumberOfSeats() +
                ", id=" + getId() +
                ", length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", basic items=" + basicItems +
                '}';
    }


    // This method calculates the maximum number of basic items that can be loaded onto the BasicRailwayCar based on its volume and cargo capacity
    public int calculateBasicItems() {
// Calculate the volume of the railway car using the calculateVolume method inherited from the parent class
        double volume = super.calculateVolume();
// Calculate the maximum number of items that can be loaded onto the railway car by dividing its volume by the cargo capacity
        int maxItems = (int) Math.floor(volume / (cargoCapacity * 0.001));
// If the maximum number of items is less than the current number of items on the railway car, print an error message and return -1
        if (maxItems < numCargo) {
            System.err.println("Number of basic items is more than the Basic Railroad Car can accommodate ");
            return -1;
        }
        return numCargo;
    }

    @Override
    public void unload() {
        System.out.println("Unloading " + basicItems.size() + " basic items from " + getType());
        basicItems.clear();
    }

    @Override
    // This method loads basic items onto the BasicRailwayCar
    public void load() {
// Calculate the number of free places on the railway car by calling the calculateBasicItems method
        int freePlace = calculateBasicItems();
// If there is at least one free place on the railway car, load basic items onto it
        if (freePlace > 0) {
// Print a message indicating how many basic items are being loaded and into what type of railway car
            System.out.println("Loading " + freePlace + " basic items into " + getType());
// Add the specified number of basic items to the basicItems list using the generateHeavyItem method of the BasicItemsDataGenerator class
            for (int i = 0; i < freePlace; i++) {
                basicItems.add(BasicItemsDataGenerator.generateHeavyItem());
            }
        } else {
// If there are no free places on the railway car, print a message indicating that it is already full and no more items can be loaded
            System.out.println(getType() + " is already full, no more basic items can be loaded");
        }
    }


}