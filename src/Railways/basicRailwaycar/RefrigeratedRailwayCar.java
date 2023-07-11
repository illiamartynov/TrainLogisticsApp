package Railways.basicRailwaycar;

import Cargo.Products;
import Data.ProductsDataGenerator;
import Interfaces.Electricity;
import Railways.IDgenerator;

import java.util.ArrayList;
import java.util.List;

public class RefrigeratedRailwayCar extends BasicRailwayCar implements Electricity {
    private int cargoCapacity;
    private int numCargo;
    private List<Products> products = new ArrayList<>();


    public RefrigeratedRailwayCar(String shipper, boolean securityInformation, double netWeight, double grossWeight,
                                  int numberOfSeats, double length, double width, double height,
                                  int cargoCapacity, int numCargo) {
        super(shipper, securityInformation, netWeight, grossWeight, numberOfSeats, length, width, height, cargoCapacity, numCargo);
        setId(IDgenerator.getId());
        this.cargoCapacity = cargoCapacity;
        this.numCargo = numCargo;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public int getNumCargo() {
        return numCargo;
    }

    @Override
    public void setNumCargo(int numCargo) {
        this.numCargo = numCargo;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }


    @Override
    public String getType() {
        return "Refrigerated Railway Car";
    }

    @Override
    public String toString() {
        return "Refrigerated Railway Car{" +
                "shipper='" + getShipper() + '\'' +
                ", securityInformation=" + getSecurityInformation() +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", numberOfSeats=" + getNumberOfSeats() +
                ", length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", products=" + products +
                '}';
    }

    // This method calculates the maximum number of products that can be loaded into the Refrigerated Railway Car based on the car's cargo capacity and volume.
    public int calculateProducts() {
        double volume = super.calculateVolume();
        int maxItems = (int) Math.floor(volume / (cargoCapacity * 0.001));
// Checks if the maximum number of products is less than the number of products already loaded into the car.
        if (maxItems < numCargo) {
            System.err.println("Number of products is more than the Refrigerated Railway Car can accommodate ");
            return -1;
        }
        return numCargo;
    }


    @Override
// This method unloads all the products from the Refrigerated Railway Car and clears the list of products.
    public void unload() {
        System.out.println("Unloading " + products.size() + " products from " + getType());
        products.clear();
    }

    @Override
// This method loads the Refrigerated Railway Car with the maximum number of products that can fit into the car.
    public void load() {
        int freePlace = calculateProducts();
        if (freePlace > 0) {
            System.out.println("Loading " + freePlace + " products into " + getType());
            for (int i = 0; i < freePlace; i++) {
                products.add(ProductsDataGenerator.generateProduct());
            }
        } else {
            System.out.println(getType() + " is already full, no more products can be loaded");
        }
    }

    @Override
    public boolean requiresElectricity() {
        return true;
    }
}