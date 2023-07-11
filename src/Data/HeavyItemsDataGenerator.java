package Data;


import Cargo.HeavyItem;

import java.util.Random;

public class HeavyItemsDataGenerator {
    private static final String[] heavyItems = {"Steel beams", "Aluminum sheets", "Lumber logs", "Construction steel rods", "Mining equipment", "Bulldozers", "Trucks", "Buses", "Coal", "Grain", "Iron ore", "Cement bags", "Brick pallets", "Chemical barrels", "Fuel tanks", "Crude oil drums", "Generators", "Turbines", "Large transformers", "Industrial boilers"};
    private static final Random random = new Random();

    public static HeavyItem generateHeavyItem() {
        String name = heavyItems[random.nextInt(heavyItems.length)];
        double amount = Math.round((random.nextDouble() * 600 + 100) * 100.0) / 100.0;
        return new HeavyItem(name, amount);

    }


}