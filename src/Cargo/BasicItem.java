package Cargo;

public class BasicItem extends Cargo{
    private String name;
    private String color;

    public BasicItem(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return color;
    }

    public void setAmount(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "HeavyItem{" +
                "name='" + name + '\'' +
                ", amount=" + color +
                '}';
    }
}
