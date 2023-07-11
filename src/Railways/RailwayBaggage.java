package Railways;

import Cargo.Baggage;
import Data.BaggageDataGenerator;

import java.util.ArrayList;

public class RailwayBaggage extends RailwayCar {
    private int numLockers;
    private int lockerCapacity;
    private boolean hasSecuritySystem;
    private boolean hasTrackingSystem;
    private String cargoType;
    private ArrayList<Baggage> baggageList = new ArrayList<>();



    public RailwayBaggage(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                          int numberOfSeats, double length, double width,
                          double height, int numLockers, int lockerCapacity) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height);
        setId(IDgenerator.getId());
        this.numLockers = numLockers;
        this.lockerCapacity = lockerCapacity;
        this.hasSecuritySystem = getSecurityInformation();

    }

    public RailwayBaggage() {

    }

    public ArrayList<Baggage> getBaggageList() {
        return baggageList;
    }

    public void setBaggageList(ArrayList<Baggage> baggageList) {
        this.baggageList = baggageList;
    }

    public int getNumLockers() {
        return numLockers;
    }

    public void setNumLockers(int numLockers) {
        this.numLockers = numLockers;
    }

    public int getLockerCapacity() {
        return lockerCapacity;
    }

    public void setLockerCapacity(int lockerCapacity) {
        this.lockerCapacity = lockerCapacity;
    }

    public boolean hasSecuritySystem() {
        return hasSecuritySystem;
    }

    public void setSecuritySystem(boolean hasSecuritySystem) {
        this.hasSecuritySystem = hasSecuritySystem;
    }

    public boolean hasTrackingSystem() {
        return hasTrackingSystem;
    }

    public void setTrackingSystem(boolean hasTrackingSystem) {
        this.hasTrackingSystem = hasTrackingSystem;
    }
    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    @Override
    public String getType() {
        return "Railroad Baggage";
    }

    public int calculateLockerCount(){
        double volume = super.calculateVolume();
        int maxLockers = (int) Math.floor(volume / (lockerCapacity * 0.001));
        if (maxLockers < numLockers) {
            System.err.println("Number of lockers is more than the capacity of the Railroad Baggage");
            return -1;
        }
        return Math.min(maxLockers, numLockers);
    }


    public String getSecurityStatus() {
        if (hasSecuritySystem && hasTrackingSystem) {
            return "The baggage has both a security system and a tracking system";
        } else if (hasSecuritySystem) {
            return "The baggage has a security system";
        } else if (hasTrackingSystem) {
            return "The baggage has a tracking system";
        } else {
            return "The baggage does not have a security or tracking system";
        }
    }
    @Override
    public String toString() {
        return "Baggage Railway Car{" +
                "shipper='" + getShipper() + '\'' +
                ", securityInformation=" + getSecurityInformation() +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", numberOfSeats=" + getNumberOfSeats() +
                ", length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", baggage=" + baggageList +
                '}';
    }




    public void load() {
        int baggage = calculateLockerCount();
        if (baggage > 0) {
            System.out.println("Loading " + baggage + " baggage into " + getType());
            for (int i = 0; i < baggage; i++) {
                baggageList.add(BaggageDataGenerator.generateBaggage());
            }
            System.out.println(baggage + " baggage have been loaded into the Baggage Railway Car.");
        } else {
            System.err.println("Failed to load baggage into the Baggage Railway Car.");
        }
    }

    @Override
    public void unload() {
        if (baggageList.isEmpty()) {
            System.err.println("The Baggage Railway Car is already empty.");
        } else {
            baggageList.clear();
            System.out.println("All baggage have been unloaded from the Baggage Railway Car.");
        }
    }

}