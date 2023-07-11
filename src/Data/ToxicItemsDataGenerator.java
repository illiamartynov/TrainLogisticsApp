package Data;

import java.util.Random;

import Cargo.ToxicItems;

public class ToxicItemsDataGenerator {

    private static final String[] toxicItems = {"Mercury", "Lead", "Cadmium", "Nickel", "Chromium", "Sulfur", "Phosphorus", "Mercurides", "Cyanides", "Formaldehyde", "Benzene", "Toluene", "Xylene", "Acetone", "Nitric acid"};



    private static final Random rand = new Random();

    public static ToxicItems generateToxicItem() {
        String name = toxicItems[rand.nextInt(toxicItems.length)];
        return new ToxicItems(name);
    }
}