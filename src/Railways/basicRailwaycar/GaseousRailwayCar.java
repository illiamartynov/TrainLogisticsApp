package Railways.basicRailwaycar;

import Cargo.Gas;
import Data.GasDataGenerator;
import Railways.IDgenerator;

import java.util.ArrayList;
import java.util.List;

public class GaseousRailwayCar extends BasicRailwayCar {
    // fields
    private int cargoCapacity;
    private int numCargo;
    private List<Gas> gases = new ArrayList<>();

    // constructor
    public GaseousRailwayCar(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                            int numberOfSeats, double length, double width, double height, int cargoCapacity, int numCargo) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height, cargoCapacity, numCargo);
        setId(IDgenerator.getId());
        this.cargoCapacity = cargoCapacity;
        this.numCargo = numCargo;

    }

    // getters and setters


    @Override
    public int getNumCargo() {
        return numCargo;
    }

    @Override
    public void setNumCargo(int numCargo) {
        this.numCargo = numCargo;
    }

    public List<Gas> getGases() {
        return gases;
    }

    public void setGases(List<Gas> gases) {
        this.gases = gases;
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
        return "Gaseous Railway Car";
    }


    public String toString() {
        return "Gaseous Railway Car{" +
                ", shipper='" + getShipper() + '\'' +
                ", securityInformation=" + getSecurityInformation() +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", numberOfSeats=" + getNumberOfSeats() +
                ", id=" + getId() +
                ", length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", gases= " + gases +
                '}';
    }

    // Override the unload method from the RailwayCar abstract class to unload gases from the GaseousRailwayCar
    @Override
    public void unload() {
// Check if there are gases in the car
        if (gases.isEmpty()) {
// If there are no gases in the car, print an error message
            System.err.println("Gaseous Railway Car is already empty.");
        } else {
// If there are gases in the car, clear the list and print a message indicating that all the gases have been unloaded
            gases.clear();
            System.out.println("All gases have been unloaded from the Gaseous Railway Car.");
        }
    }

    // Method to calculate the number of gases that can be loaded into the GaseousRailwayCar
    public int calculateGases() {
// Calculate the volume of the car using the calculateVolume method from the RailwayCar abstract class
        double volume = super.calculateVolume();
// Calculate the maximum number of gases that can be loaded based on the cargo capacity of the car and the volume of each gas
        int maxItems = (int) Math.floor(volume / (cargoCapacity * 0.001));
// Check if the maximum number of gases that can be loaded is less than the number of gases already in the car
        if (maxItems < numCargo) {
// If the maximum number of gases that can be loaded is less than the number of gases already in the car, print an error message
            System.err.println("Number of gases is more than the Gaseous Railway Car can accommodate.");
            return -1;
        }
        return numCargo;
    }

    // Override the load method from the RailwayCar abstract class to load gases into the GaseousRailwayCar
    @Override
    public void load() {
// Calculate the number of gases that can be loaded using the calculateGases method
        int availablePlaceForGases = calculateGases();
// Check if there is space for the gases in the car
        if (availablePlaceForGases > 0) {
// If there is space for the gases, print a message indicating the number of gases being loaded and add the gases to the list
            System.out.println("Loading " + availablePlaceForGases + " gases into " + getType());
            for (int i = 0; i < availablePlaceForGases; i++) {
                gases.add(GasDataGenerator.generateGas());
            }
        } else {
// If there is no space for the gases, print a message indicating that the car is already full
            System.out.println(getType() + " is already full, no more gases can be loaded");
        }
    }





}
