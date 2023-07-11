package Cargo;

public class Dish extends Cargo{
    private String name;

    public Dish(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
