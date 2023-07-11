package Data;


import Cargo.BasicItem;
import Cargo.HeavyItem;

import java.util.Random;

public class BasicItemsDataGenerator {
    private static final String[] basicItems = {"Pencils", "Paper", "Scissors", "Staplers", "Glue sticks", "Rulers", "Markers", "Highlighters", "Notebooks", "Folders", "Binders", "Envelopes", "Stamps", "Post-it notes", "Tape", "Rubber bands", "Pins", "Clips", "Pushpins", "White-out"};

    // Массив colors
    private static final String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange", "Purple", "Pink", "Black", "White", "Gray", "Brown", "Beige", "Navy", "Teal", "Maroon", "Magenta", "Turquoise", "Gold", "Silver", "Bronze", "Copper"};
    private static final Random random = new Random();

    public static BasicItem generateHeavyItem() {
        String name = basicItems[random.nextInt(basicItems.length)];
        String color = colors[random.nextInt(colors.length)];
        return new BasicItem(name, color);

    }


}