package Railways;


import Interfaces.Load;
import Interfaces.Unload;


public abstract class RailwayCar implements Load, Unload {
    // fields
    private String shipper;
    private boolean securityInformation;
    private double netWeight;
    private double grossWeight;
    private int numberOfSeats;
    private int id;
    private boolean requiresElectricalConnection;
    private double length;
    private double width;
    private double height;

    // constructor
    public RailwayCar(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                      int numberOfSeats, double length, double width, double height) {
        setId(IDgenerator.getId());
        this.shipper = shipper;
        this.securityInformation = securityInformation;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.numberOfSeats = numberOfSeats;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public RailwayCar() {

    }

    // getters and setters
    public String getShipper() {
        return this.shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public boolean getSecurityInformation() {
        return securityInformation;
    }

    public void setSecurityInformation(boolean securityInformation) {
        this.securityInformation = securityInformation;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public double getWholeWeight(){
        return getGrossWeight() + getNetWeight();
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLength() {
        return length;
    }

    public boolean getRequiresElectricalConnection() {
        return requiresElectricalConnection;
    }

    public void setRequiresElectricalConnection(boolean requiresElectricalConnection) {
        this.requiresElectricalConnection = requiresElectricalConnection;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double calculateVolume() {
        return length * width * height;
    }
    // getting type of Railway car
    public abstract String getType();

    public String toString() {
        return "RailwayCar{" +
                "shipper='" + shipper + '\'' +
                ", securityInformation=" + securityInformation +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", numberOfSeats=" + numberOfSeats +
                ", id=" + id +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", volume=" + calculateVolume() +
                '}';
    }


}