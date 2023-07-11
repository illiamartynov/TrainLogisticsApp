package Cargo;

public class Liquids extends Cargo{
    private String name;

    public Liquids(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Liquids{" +
                "name='" + name + '\'' +
                '}';
    }
}
