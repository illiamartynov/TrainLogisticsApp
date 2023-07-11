package Railways;

import Cargo.Passenger;
import Data.PassengerDataGenerator;
import Interfaces.Electricity;

import java.util.ArrayList;
import java.util.List;

public class PassengerRailwayCar extends RailwayCar implements Electricity {

    private List<Passenger> passengers = new ArrayList<>();

    public PassengerRailwayCar(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                               int numberOfSeats, double length, double width, double height) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height);
    }

    public PassengerRailwayCar() {

    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String getType() {
        return "Passenger Railway Car";
    }

    @Override
    public void unload() {
        if (passengers.isEmpty()) {
            System.err.println("The Passengers railway car is already empty.");
        } else {
            passengers.clear();
            System.out.println("All passengers were unloaded from passenger railway car.");
        }
    }

    @Override
    public void load() {
        int availableSeats = getNumberOfSeats() - passengers.size();
        if (availableSeats > 0) {
            System.out.println("Loading " + availableSeats + " passengers into " + getType());
            for (int i = 0; i < availableSeats; i++) {
                passengers.add(PassengerDataGenerator.generatePassenger());
            }
        } else {
            System.out.println(getType() + " is already full, no more passengers can be loaded");
        }
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
                ", passengers=" + passengers +
                '}';
    }

    @Override
    public boolean requiresElectricity() {
        return true;
    }
}
