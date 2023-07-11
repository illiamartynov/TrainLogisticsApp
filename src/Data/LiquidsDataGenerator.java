package Data;

import java.util.Random;

import Cargo.Liquids;

public class LiquidsDataGenerator {

    private static final String[] liquidTypes = {"Water", "Gasoline", "Diesel", "Crude Oil", "Molasses", "Milk", "Wine", "Juice", "Beer", "Vodka", "Whiskey", "Tea", "Coffee", "Vinegar", "Honey", "Soy Sauce", "Liquid Soap"};




    private static final Random rand = new Random();

    public static Liquids generateToxicItem() {
        String name = liquidTypes[rand.nextInt(liquidTypes.length)];
        return new Liquids(name);
    }
}