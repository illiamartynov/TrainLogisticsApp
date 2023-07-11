package Cargo;

public class ExplosiveItem extends Cargo{
    private String name;

    public ExplosiveItem(String name) {
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
        return "ExplosiveItems{" +
                "name='" + name + '\'' +
                '}';
    }
}
