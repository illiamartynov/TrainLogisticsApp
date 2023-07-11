package Railways.basicRailwaycar;

import Cargo.Liquids;
import Data.LiquidsDataGenerator;
import Railways.IDgenerator;

import java.util.ArrayList;
import java.util.List;

public class LiquidRailwayCar extends BasicRailwayCar {
    // fields
    private int liquidCapacity;
    private int numOfLiquid;
    private List<Liquids> liquids = new ArrayList<>();


    // constructor
    public LiquidRailwayCar(String shipper, boolean securityInformation, double netWeight, double grossWeight, int numberOfSeats, double length, double width, double height, int liquidCapacity, int numOfLiquid) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height, liquidCapacity, numOfLiquid);
        setId(IDgenerator.getId());
        this.liquidCapacity = liquidCapacity;
        this.numOfLiquid = numOfLiquid;
    }


    // getters and setters


    public int getLiquidCapacity() {
        return liquidCapacity;
    }

    public void setLiquidCapacity(int liquidCapacity) {
        this.liquidCapacity = liquidCapacity;
    }

    public int getNumOfLiquid() {
        return numOfLiquid;
    }

    public void setNumOfLiquid(int numOfLiquid) {
        this.numOfLiquid = numOfLiquid;
    }

    public List<Liquids> getLiquids() {
        return liquids;
    }

    public void setLiquids(List<Liquids> liquids) {
        this.liquids = liquids;
    }


    // method to get the type of railway car
    @Override
    public String getType() {
        return "Liquid Railway Car";
    }


    @Override
    public String toString() {
        return "Liquid Railway Car{" + "shipper='" + getShipper() + '\'' + ", securityInformation=" + getSecurityInformation() + ", netWeight=" + getNetWeight() + ", grossWeight=" + getGrossWeight() + ", numberOfSeats=" + getNumberOfSeats() + ", length=" + getLength() + ", width=" + getWidth() + ", height=" + getHeight() + ", liquids=" + liquids + '}';
    }

    // This method calculates the maximum number of liquids that can be loaded onto the Liquid Railway Car
    public int calculateLiquids() {
// Calculates the volume of the Liquid Railway Car
        double volume = super.calculateVolume();
// Calculates the maximum number of liquids that can be loaded onto the Liquid Railway Car
        int maxMeals = (int) Math.floor(volume / (liquidCapacity));
// Checks if the maximum number of liquids that can be loaded is less than the number of liquids already loaded
        if (maxMeals < numOfLiquid) {
// Prints an error message to the console
            System.err.println("Number of liquids is more than the Liquid Railway Car can accommodate ");
// Returns -1 to indicate that the loading of liquids has failed
            return -1;
        }
        return numOfLiquid;
    }

    // This method unloads all liquids from the Liquid Railway Car
    @Override
    public void unload() {
        // Prints a message to the console indicating the number of liquids being unloaded and the type of Railway Car
        System.out.println("Unloading " + liquids.size() + " liquids from " + getType());
        // Removes all liquids from the Liquid Railway Car
        liquids.clear();
    }

    // This method loads liquids onto the Liquid Railway Car
    @Override
    public void load() {
        // Calculates the available space on the Liquid Railway Car for loading liquids
        int availablePlace = calculateLiquids();
        if (availablePlace > 0) {
            // Prints a message to the console indicating the number of liquids being loaded and the type of Railway Car
            System.out.println("Loading " + availablePlace + " liquids into " + getType());
            // Adds the specified number of liquids to the Liquid Railway Car
            for (int i = 0; i < availablePlace; i++) {
                liquids.add(LiquidsDataGenerator.generateToxicItem());
            }
        } else {
            // Prints a message to the console indicating that the loading of liquids has failed because the Liquid Railway Car is already full
            System.out.println(getType() + " is already full, no more liquids can be loaded");
        }
    }

}
