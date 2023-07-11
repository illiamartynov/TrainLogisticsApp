package Cargo;


public class Baggage extends Cargo{

    private String owner;
    private double weight;

    public Baggage(String owner, double weight) {
        this.owner = owner;
        this.weight = weight;
    }

    public String getDescription() {
        return owner;
    }

    public void setDescription(String description) {
        this.owner = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "owner='" + owner + '\'' +
                ", weight=" + weight +
                '}';
    }
}
