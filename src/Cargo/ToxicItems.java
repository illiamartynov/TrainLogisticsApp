package Cargo;

public class ToxicItems extends Cargo{
    private String name;

    public ToxicItems(String name) {
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
        return "ToxicItems{" +
                "name='" + name + '\'' +
                '}';
    }
}
