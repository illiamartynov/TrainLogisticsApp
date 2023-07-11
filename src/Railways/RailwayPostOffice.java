package Railways;


import Cargo.Letter;
import Data.LetterDataGenerator;
import Exceptions.MailboxCapacityExceededException;
import Interfaces.Electricity;

import java.util.ArrayList;

public class RailwayPostOffice extends RailwayCar implements Electricity {
    private int numMailboxes;
    private int mailboxCapacity;
    private String cargoType;
    private ArrayList<Letter> letters = new ArrayList<>();


    public RailwayPostOffice(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                             int numberOfSeats, double length, double width,
                             double height, int numMailboxes, int mailboxCapacity) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height);
        setId(IDgenerator.getId());
        this.numMailboxes = numMailboxes;
        this.mailboxCapacity = mailboxCapacity;
        setRequiresElectricalConnection(true);
    }

    public ArrayList<Letter> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<Letter> letters) {
        this.letters = letters;
    }

    public int getNumMailboxes() {
        return numMailboxes;
    }

    public void setNumMailboxes(int numMailboxes) {
        this.numMailboxes = numMailboxes;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    @Override
    public String getType() {
        return "Railway Post Office";
    }

    public int calculateMailboxCount() {
        double volume = super.calculateVolume();
        int maxMailboxes = (int) Math.floor(volume / (mailboxCapacity * 0.001));
        if (maxMailboxes < numMailboxes) {
            throw new MailboxCapacityExceededException("Number of mailboxes is more than the capacity of the Railway Post Office");
        }
        return Math.min(maxMailboxes, numMailboxes);
    }

    @Override
    public String toString() {
        return "Railway Post Office{" +
                "shipper='" + getShipper() + '\'' +
                ", securityInformation=" + getSecurityInformation() +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", numberOfSeats=" + getNumberOfSeats() +
                ", length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", Railway Post Office=" + letters +
                '}';
    }

    @Override
    public void load() {
        int numMailboxes = calculateMailboxCount();
        if (numMailboxes > 0) {
            System.out.println("Loading " + numMailboxes + " mails into " + getType());
            for (int i = 0; i < numMailboxes; i++) {
                letters.add(LetterDataGenerator.generateLetter());
            }
            System.out.println(numMailboxes + " mailboxes have been loaded into the Railway Post Office.");
        } else {
            System.err.println("Failed to load mailboxes into the Railway Post Office.");
        }
    }

    @Override
    public void unload() {
        if (letters.isEmpty()) {
            System.err.println("The Railway Post Office is already empty.");
        } else {
            letters.clear();
            System.out.println("All letters have been unloaded from the Railway Post Office.");
        }
    }

    @Override
    public boolean requiresElectricity() {
        return true;
    }
}





